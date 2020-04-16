<template>
  <v-data-table
    :headers="headers"
    :items="people"
    :options.sync="optionsTable"
    :server-items-length="serverItemsLength"
    @pagination="updatePagination"
    class="elevation-1"
    sort-by="calories"
  >
    <template v-slot:top>
      <v-toolbar flat>
        <v-spacer></v-spacer>
        <v-dialog max-width="1000px" v-model="dialog">
          <template v-slot:activator="{ on }">
            <v-btn class="mb-2" color="primary" dark v-on="on">New Person</v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span class="headline">{{ formTitle }}</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" md="8" sm="6">
                    <v-text-field
                      :rules="[() => !!editedItem.name || 'This field is required']" clearable
                      label="Name of Physical Person *" outlined
                      ref="name"
                      required v-model="editedItem.name"
                    />
                  </v-col>
                  <v-col cols="12" md="4" sm="6">
                    <v-text-field
                      :rules="[() => !!editedItem.telephone || 'This field is required']" clearable label="Telephone *"
                      outlined
                      v-mask="['(##) ####-####', '(##) #####-####']"
                      ref="telephone" required
                      v-model="editedItem.telephone"
                    />
                  </v-col>
                  <v-col cols="12" md="6" sm="6">
                    <v-text-field
                      :rules="[() => !!editedItem.nationality || 'This field is required']" clearable
                      label="Nationality *" outlined
                      ref="nationality"
                      required v-model="editedItem.nationality"
                    />
                  </v-col>
                  <v-col cols="12" md="6" sm="6">
                    <v-text-field
                      :rules="[() => !!editedItem.naturalness || 'This field is required']" clearable
                      label="Naturalness *" outlined
                      ref="naturalness"
                      required v-model="editedItem.naturalness"
                    />
                  </v-col>
                  <v-col cols="12" md="6" sm="6">
                    <v-text-field
                      :rules="[() => !!editedItem.email || 'This field is required']" clearable email
                      label="E-mail *"
                      outlined
                      ref="email"
                      required v-model="editedItem.email"
                    />
                  </v-col>
                  <v-col cols="12" md="6" sm="6">
                    <v-text-field
                      :rules="[() => !!editedItem.cpf || 'This field is required']" clearable label="CPF *" outlined
                      ref="cpf"
                      v-mask="'###.###.###-##'"
                      required v-model="editedItem.cpf"
                    />
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn @click="close" color="blue darken-1" text>Cancel</v-btn>
              <v-btn @click="save" color="blue darken-1" text>Save</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <template v-slot:item.actions="{ item }">
      <v-icon
        @click="editItem(item)"
        class="mr-2"
        small
      >
        mdi-pencil
      </v-icon>
      <v-icon
        @click="deleteItem(item)"
        small
      >
        mdi-delete
      </v-icon>
    </template>
    <template v-slot:no-data>
      <span>There are no records, try to </span>
      <a @click="findPhysicalPeople">update.</a>
    </template>
  </v-data-table>
</template>
<script>
import { mask } from 'vue-the-mask'

export default {
  name: 'PersonTable',
  directives: {
    mask
  },
  data: () => ({
    dialog: false,
    headers: [
      { text: 'Name', align: 'start', value: 'name' },
      { text: 'Telephone', value: 'telephone' },
      { text: 'Nationality', value: 'nationality' },
      { text: 'Naturalness', value: 'naturalness' },
      { text: 'CPF', value: 'cpf' },
      { text: 'Actions', value: 'actions', sortable: false }
    ],
    people: [],
    editedIndex: -1,
    formHasErrors: false,
    editedItem: {
      name: '',
      telephone: '',
      address: '',
      nationality: '',
      dateOfBirth: '2001-11-19',
      naturalness: '',
      email: '',
      cpf: ''
    },
    defaultItem: {
      name: '',
      telephone: '',
      address: '',
      nationality: '',
      dateOfBirth: '2001-11-19',
      naturalness: '',
      email: '',
      cpf: ''
    },
    serverItemsLength: 0,
    optionsTable: {
      page: 1,
      itemsPerPage: 10,
      pageStart: 1,
      pageStop: 1,
      pageCount: 1,
      itemsLength: 10,
      rowsPerPageItems: [1, 2, 4, 8, 16]
    }
  }),
  /**
   */
  computed: {
    formTitle () {
      return this.editedIndex === -1 ? 'Inclusion Person' : 'Change Person'
    },
    form () {
      return {
        name: this.editedItem.name,
        telephone: this.editedItem.telephone,
        nationality: this.editedItem.nationality,
        dateOfBirth: this.editedItem.dateOfBirth,
        naturalness: this.editedItem.naturalness,
        email: this.editedItem.email,
        cpf: this.editedItem.cpf
      }
    }
  },
  /**
   */
  watch: {
    dialog (val) {
      val || this.close()
    }
  },
  /**
   */
  methods: {
    /**
     */
    findPhysicalPeople ({ page, size }) {
      this.$http.get('/physical_people/v1', { params: { page, size } })
        .then((response) => {
          this.serverItemsLength = response.data.totalElements
          this.people = response.data.content
        })
    },
    /**
     */
    updatePagination (pagination) {
      this.findPhysicalPeople({ page: pagination.page, size: pagination.itemsPerPage })
    },
    /**
     */
    editItem (item) {
      this.editedIndex = this.people.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialog = true
    },
    /**
     */
    deleteItem (item) {
      const index = this.people.indexOf(item)
      if (confirm('Are you sure you want to delete this item?')) {
        this.$http.delete(`/physical_people/v1/${this.people[index].id}`)
          .then(() => {
            this.people.splice(index, 1)
            this.updatePagination({ page: this.optionsTable.page, size: this.optionsTable.itemsPerPage })
          })
      }
    },
    /**
     */
    close () {
      this.dialog = false
      setTimeout(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      }, 300)
    },
    /**
     */
    validateForm () {
      return new Promise(((resolve, reject) => {
        this.formHasErrors = false
        Object.keys(this.form).forEach(f => {
          if (!this.form[f]) {
            this.formHasErrors = true
          }
          if (this.$refs[f]) {
            this.$refs[f].validate(true)
          }
        })

        if (!this.formHasErrors) {
          return resolve()
        }
        return reject()
      }))
    },
    /**
     */
    save () {
      this.validateForm()
        .then(() => {
          if (this.editedIndex > -1) {
            this.$http.put(`/physical_people/v1/${this.editedItem.id}`, this.editedItem)
              .then((response) => {
                Object.assign(this.people[this.editedIndex], response.data)
                this.close()
              })
          }
          else {
            this.$http.post(`/physical_people/v1`, this.editedItem)
              .then((response) => {
                this.editedItem.id = response.data.id
                this.updatePagination({ page: this.optionsTable.page, size: this.optionsTable.itemsPerPage })
                this.close()
              })
          }
        })
    }
  }
}
</script>

<style scoped>
</style>