<template>
  <div>
    <input v-model="keyword" type="text" placeholder="건물명을 입력하세요"/>
    <button @click="searchKeyword" class="btn btn-primary d-inline-block"><i class="fa-regular fa-magnifying-glass"></i></button>
  </div>
</template>
<script>
import http from "@/api/http.js";

export default {
  name: "KeywordSearch",
  data() {
    return {
      keyword: "",
    };
  },
  methods: {
    searchKeyword() {
      if (this.keyword !== "") {
        http.get(`/house-deals?aptName=${this.keyword}`)
        .then(({ data }) => {
          this.$emit("searched-houses", data);
        });
      } else {
        console.log("null keyword!");
      }
    }
  }
}
</script>
<style scoped>
  
</style>