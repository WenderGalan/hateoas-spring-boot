<template>
  <v-app>
    <v-content>
      <h1 class="mb-12" align="center">About the project</h1>
      <v-col cols="12">
        <v-row align="center" justify="center" class="mb-12">
          <h3>This API is designed for study using various tools and dependencies
            to enhance my knowledge of the dependencies.</h3>
          <h3>
            If you need more information go to github.
          </h3>
        </v-row>
      </v-col>
      <v-col cols="12">
        <v-row align="center" justify="center">
          <v-img
            :src="urlLogo"
            @click="openGithub"
            class="img"
            max-height="350px"
            max-width="350px"
          />
        </v-row>
        <v-row align="center" justify="center">
          <p>Click on the image to be redirected.</p>
        </v-row>
      </v-col>
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: 'About',
  data: () => ({
    urlLogo: 'https://github.githubassets.com/images/modules/logos_page/Octocat.png'
  }),
  methods: {
    openGithub () {
      window.open('https://github.com/WenderGalan/person-vue-spring-boot', '_blank')
    }
  }
}
</script>

<style scoped>
.img :hover {
  cursor: pointer;
  align-items: center;
}
</style>