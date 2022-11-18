<template>
  <div id="app">
    <the-header-navbar></the-header-navbar>
    <router-view></router-view>
  </div>
</template>

<script>
import TheHeaderNavbar from "@/components/TheHeaderNavbar";

export default {
  name: "App",
  components: {
    TheHeaderNavbar,
  },
};
</script>

<style>
@font-face {
  font-family: "LeferiPoint-WhiteObliqueA";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/LeferiPoint-WhiteObliqueA.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
  text-decoration: none;
}

#app {
  font-family: "LeferiPoint-WhiteObliqueA", Avenir, Helvetica, Arial, sans-serif;
  /* -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale; */
  text-align: center;
  font-weight: bold;
  /* color: #2c3e50; */
}

a.router-link-exact-active {
  color: #17a2b8;
  /* color: #89bfef; */
}

a.router-link-exact-active:hover {
  text-decoration: none;
  color: #6E8A8E;
}
</style>
