<template>
  <v-data-table
    :headers="headers"
    :items="people"
    class="elevation-1"
    sort-by="calories"
  >
    <template v-slot:top>
      <v-toolbar flat>
        <v-spacer></v-spacer>
        <v-dialog max-width="500px" v-model="dialog">
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
                  <v-col cols="12" md="4" sm="6">
                    <v-text-field label="Dessert name" v-model="editedItem.name"></v-text-field>
                  </v-col>
                  <v-col cols="12" md="4" sm="6">
                    <v-text-field label="Calories" v-model="editedItem.calories"></v-text-field>
                  </v-col>
                  <v-col cols="12" md="4" sm="6">
                    <v-text-field label="Fat (g)" v-model="editedItem.fat"></v-text-field>
                  </v-col>
                  <v-col cols="12" md="4" sm="6">
                    <v-text-field label="Carbs (g)" v-model="editedItem.carbs"></v-text-field>
                  </v-col>
                  <v-col cols="12" md="4" sm="6">
                    <v-text-field label="Protein (g)" v-model="editedItem.protein"></v-text-field>
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
      <span>No records</span>
    </template>
  </v-data-table>
</template>
<script>
export default {
  name: 'PersonTable',
  data: () => ({
    dialog: false,
    headers: [
      { text: 'Name', align: 'start', value: 'name' },
      { text: 'Telephone', value: 'telephone' },
      { text: 'Address', value: 'address' },
      { text: 'Nationality', value: 'nationality' },
      { text: 'Date of Birth', value: 'dateOfBirth' },
      { text: 'Naturalness', value: 'naturalness' },
      { text: 'CPF', value: 'cpf' },
      { text: 'Actions', value: 'actions', sortable: false }
    ],
    people: [],
    editedIndex: -1,
    editedItem: {
      name: '',
      telephone: '',
      address: '',
      nationality: '',
      dateOfBirth: '',
      naturaless: '',
      email: '',
      cpf: ''
    },
    defaultItem: {
      name: '',
      telephone: '',
      address: '',
      nationality: '',
      dateOfBirth: '',
      naturaless: '',
      email: '',
      cpf: ''
    }
  }),
  /**
   */
  computed: {
    formTitle () {
      return this.editedIndex === -1 ? 'Inclusion Person' : 'Change Person'
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
  created () {
    this.initialize()
  },
  /**
   */
  methods: {
    /**
     */
    initialize () {
      this.people = [
        {
          name: 'Wender Galan'
        }
      ]
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
      confirm('Are you sure you want to delete this item?') && this.people.splice(index, 1)
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
    save () {
      if (this.editedIndex > -1) {
        Object.assign(this.people[this.editedIndex], this.editedItem)
      }
      else {
        this.people.push(this.editedItem)
      }
      this.close()
    }
  }
}
</script>

<style scoped>

</style>