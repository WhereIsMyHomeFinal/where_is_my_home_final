<template>
  <div>
    <input v-model="keyword" type="text" placeholder="건물명을 입력하세요" />
    <button @click="searchKeyword" class="btn btn-primary">
      <font-awesome-icon class="font-awesome-icon" icon="fas fa-search" />
    </button>
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
        http.get(`/house-deals?aptName=${this.keyword}`).then(({ data }) => {
          this.$emit("searched-houses", data);
        });
      } else {
        console.log("null keyword!");
      }
    },
  },
};
</script>
<style scoped>
.btn {
  margin-left: 5px;
  margin-top: 4px;
  padding-top: 7px;
  height: 30px;
}

.font-awesome-icon {
  align-items: center;
  vertical-align: top;
}
</style>
