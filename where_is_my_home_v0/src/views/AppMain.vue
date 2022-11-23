<script setup>
// import vueMkHeader from "@/assets/main_02.png";
</script>
<template>
  <div id="hero-slider">
    <div id="logo" class="mask">
      <span class="logo-text masked">Martin Rohde</span>
    </div>
    <div id="slideshow">
      <div id="slides-main" class="slides">
        <div class="slide" data-index="0">
          <div class="abs-mask">
            <div class="slide-image" style="background-image: url('https://bit.ly/3AFexJI')"></div>
          </div>
        </div>
        <div class="slide" data-index="1">
          <div class="abs-mask">
            <div class="slide-image" style="background-image: url('https://bit.ly/3EuNbqU')"></div>
          </div>
        </div>
        <div class="slide" data-index="2">
          <div class="abs-mask">
            <div class="slide-image" style="background-image: url('https://bit.ly/3tPlfZT')"></div>
          </div>
        </div>
        <div class="slide" data-index="3">
          <div class="abs-mask">
            <div class="slide-image" style="background-image: url('https://bit.ly/3VfpIjW')"></div>
          </div>
        </div>
      </div>
      <div id="slides-aux" class="slides mask">
        <h2 class="slide-title slide" data-index="0"><a class="slide-title-link" href="#">#64 Paradigm</a></h2>
        <h2 class="slide-title slide" data-index="1"><a class="slide-title-link" href="#">Industrial Works</a></h2>
        <h2 class="slide-title slide" data-index="2"><a class="slide-title-link" href="#">Future Lights</a></h2>
        <h2 class="slide-title slide" data-index="3"><a class="slide-title-link" href="#">The Colossal</a></h2>
      </div>
    </div>
    <div id="info">
      <div class="slider-title-wrapper">
        <span class="line"></span>
        <h1 class="slider-title">
          <span>Projects</span>
        </h1>
      </div>
      <div class="about">
        <p>
          A pure CSS/JS slider layout<br />
          Developed for Toptal engineering blog<br />
          by <a href="http://stefan.lynxdev.io" target="_blank">Stefan V</a>, repo on
          <a href="https://github.com/vitass/pure-css-js-slider" target="_blank">Github</a>
        </p>
      </div>
    </div>
    <nav id="slider-nav">
      <span class="current">01</span>
      <span class="sep"></span>
      <span class="total">04</span>
    </nav>
  </div>
</template>

<script>
import { heroSlider } from "@/assets/js/main";
export default {
  name: "AppMain",
  mounted() {
    window.addEventListener("load", heroSlider().init);
    window.addEventListener("resize", heroSlider().resize);
  },
};
</script>

<style scoped>
/* .underline-steelblue {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%, rgba(72, 190, 233, 0.3) 30%);
} */
@import "@/assets/css/reset.css";
@import "@/assets/css/style.css";
@import "https://fonts.googleapis.com/css?family=Muli:300,400,700,900";

.slide-title-link {
  color: aliceblue;
}
</style>
