<script setup>
import vueMkHeader from "@/assets/main_02.png";
</script>
<script>
export default {
  name: "AppMain",
  props: {
    msg: String,
  },
};
</script>
<template>
  <div>
    <Header>
      <div class="page-header min-vh-100" :style="`background-image: url(${vueMkHeader})`" loading="lazy">
        <div class="container">
          <div class="row">
            <div class="col-lg-7 text-center mx-auto position-relative">
              <h1 class="text-white pt-3 mt-n5 me-2" :style="{ display: 'inline-block ' }"></h1>
              <p class="lead text-white px-5 mt-3" :style="{ fontWeight: '500' }">
                우리가 사랑하는 곳은 집이다. 발은 떠나도 마음이 떠나지 않는 곳이 우리의 집이다. <br/><br/>
                올리버 웬델 홈스(Oliver Wendell Holmes, 미국의 의학자, 시인)
              </p>
            </div>
          </div>
        </div>
      </div>
    </Header>
  </div>
  <!-- <b-img :src="require('@/assets/main_02.png')" fluid /> -->
</template>

<style scoped>
/* .underline-steelblue {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%, rgba(72, 190, 233, 0.3) 30%);
} */
</style>
