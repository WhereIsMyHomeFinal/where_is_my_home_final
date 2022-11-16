<script setup>
/*
=========================================================
* Vue Material Kit 2 - v2.0.0
=========================================================

* Product Page: https://www.creative-tim.com/product/vue-material-kit
* Copyright 2022 Creative Tim (https://www.creative-tim.com)

Coded by www.creative-tim.com

 =========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
*/
import { RouterView } from "vue-router";
</script>

<template>
  <router-view id="app" />
</template>

<style>
@font-face {
  font-family: "LeferiPoint-WhiteObliqueA";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/LeferiPoint-WhiteObliqueA.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}

#app {
  font-family: "LeferiPoint-WhiteObliqueA", Avenir, Helvetica, Arial, sans-serif;
}
</style>
