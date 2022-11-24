<template>
  <div class="pb-2 d-flex justify-content-evenly">
    <div class="col-lg-4 col-md-4 col-sm-4">
      <fieldset>
        <select v-model="selectSido" @change="onSidoChange" class="array-select form-control form-select" aria-label="example">
          <option value="default" selected>시 선택</option>
          <option v-for="(item, index) in sido" :key="index" :value="item.sidoCode">{{ item.sidoName }}</option>
        </select>
      </fieldset>
    </div>
    <div class="col-lg-4 col-md-4 col-sm-4">
      <fieldset>
        <select v-model="selectGugun" @change="onGugunChange" class="array-select form-control form-select" aria-label="example">
          <option value="default" selected>구 선택</option>
          <option v-for="(item, index) in gugun" :key="index" :value="item.gugunCode">{{ item.gugunName }}</option>
        </select>
      </fieldset>
    </div>
    <div class="col-lg-4 col-md-4 col-sm-4">
      <fieldset>
        <select v-model="selectDong" @change="onDongChange" class="array-select form-control form-select" aria-label="example">
          <option value="default" selected>동 선택</option>
          <option v-for="(item, index) in dong" :key="index" :value="item.dongName">{{ item.dongName }}</option>
        </select>
      </fieldset>
    </div>
  </div>
</template>
<script>
import http from "@/api/http.js";
export default {
  name: "DongSearch",
  data() {
    return {
      sido: [],
      gugun: [],
      dong: [],
      selectSido: "", 
      selectGugun: "", 
      selectDong: "",
    };
  },
  created() {
    http.get("/house-deals/sido")
    .then(({ data }) => this.sido = data);
  },
  methods: {
    onSidoChange() {
      http.get(`/house-deals/${this.selectSido}/gugun`)
      .then(({ data }) => this.gugun = data);
    },
    onGugunChange() {
      http.get(`/house-deals/${this.selectGugun}/dong`)
      .then(({ data }) => this.dong = data);
    },
    onDongChange() {
      http.get(`/house-deals?dongName=${this.selectDong}`)
      .then(({ data }) => {
        if (data.length == 0) {
          alert("해당 동에 매물이 없습니다!");
        } else {
          this.$emit("searched-houses", data);
        }
      });
    }
  },
}
</script>
<style scoped></style>