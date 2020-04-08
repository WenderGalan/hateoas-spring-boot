<template>
  <v-card
    dark
    flat
    tile
  >
    <v-toolbar
      elevation="5"
      dark
      dense
    >
      <v-toolbar-title
        class="headline text-uppercase mr-4"
      >
        <span>PERSON</span>
        <span class="font-weight-light">API</span>
      </v-toolbar-title>
      <v-spacer />
      <v-toolbar-items>
        <v-menu>
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              v-bind="attrs"
              v-on="on"
            >
              <span>Version</span>
            </v-btn>
          </template>

          <v-list>
            <v-list-item @click="openV1">
              <v-list-item-title>V1</v-list-item-title>
            </v-list-item>
            <v-list-item @click="openV2">
              <v-list-item-title>V2</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
        <v-btn
          to="/about"
        >About
        </v-btn>
      </v-toolbar-items>
    </v-toolbar>
  </v-card>
</template>

<script>
export default {
  name: 'Toolbar',
  methods: {
    openV1 () {
      console.log('~> Vai para a API V1')
    },
    openV2 () {
      console.log('~> Vai para a API V2')
    }
  }
}
</script>

<style scoped>

</style>