<template>
  <b-container class="bv-example-row mt-3 text-center">
    
    <router-view></router-view>
  </b-container>
</template>
<script>
export default {
  name: "AppBoard",
};
</script>
<style scoped>
.underline-hotpink {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%, rgba(231, 27, 139, 0.3) 30%);
}
h3 {
  text-align: start;
  margin-left: 25px;
}
</style>
