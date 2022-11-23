<template>
  <div id="hero-slider">
    <div id="logo" class="mask">
      <span class="logo-text masked">Where is my home?</span>
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
        <h2 class="slide-title slide" data-index="0">
          <a class="slide-title-link" href="#">#64 Paradigm</a>
        </h2>
        <h2 class="slide-title slide" data-index="1">
          <a class="slide-title-link" href="#">Industrial Works</a>
        </h2>
        <h2 class="slide-title slide" data-index="2">
          <a class="slide-title-link" href="#">Future Lights</a>
        </h2>
        <h2 class="slide-title slide" data-index="3">
          <a class="slide-title-link" href="#">The Colossal</a>
        </h2>
      </div>
    </div>
    <div id="info">
      <!-- <div class="slider-title-wrapper">
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
      </div> -->
    </div>
    <nav id="slider-nav">
      <span class="current">01</span>
      <span class="sep"></span>
      <span class="total">04</span>
    </nav>
  </div>
</template>

<script>
export default {
  name: "AppMain",
  data() {
    return {
      slider: {},
    };
  },
  mounted() {
    this.slider = this.heroSlider();
    this.slider.init();
    this.slider.resize();
  },
  methods: {
    utils() {
      /**
       * Returns max height value for a nodelist
       * @param {NodeList} nodeList The node list to calculate max height of
       */
      const calcMaxHeight = function (items) {
        let maxHeight = 0;

        items.forEach((item) => {
          const h = item.clientHeight;
          maxHeight = h > maxHeight ? h : maxHeight;
        });
        return maxHeight;
      };

      /**
       * Removes Classes from NodeList
       * @param {NodeList} nodeList The node list to remove classes from
       * @param {Array} cssClasses Array of CSS classes to be removed
       */
      function removeClasses(nodeList, cssClasses) {
        for (let i = 0; i < nodeList.length; i++) {
          nodeList[i].classList.remove(...cssClasses);
        }
      }

      /**
       * Adds Classes from NodeList
       * @param {NodeList} nodeList The node list to add classes to
       * @param {Array} cssClasses Array of CSS classes to be added
       */
      function addClasses(nodeList, cssClasses) {
        for (let i = 0; i < nodeList.length; i++) {
          nodeList[i].classList.add(...cssClasses);
        }
      }

      /**
       * Behaves the same as setInterval except uses requestAnimationFrame() where possible for better performance
       * @param {function} fn The callback function
       * @param {int} delay The delay in milliseconds
       */
      const requestInterval = function (fn, delay) {
        const requestAnimFrame = (function () {
          return (
            window.requestAnimationFrame ||
            function (callback, element) {
              window.setTimeout(callback, 1000 / 60);
            }
          );
        })();

        let start = new Date().getTime(),
          handle = {};

        function loop() {
          const current = new Date().getTime(),
            delta = current - start;

          if (delta >= delay) {
            fn.call();
            start = new Date().getTime();
          }

          handle.value = requestAnimFrame(loop);
        }

        handle.value = requestAnimFrame(loop);
        return handle;
      };

      /**
       * Behaves the same as clearInterval except uses cancelRequestAnimationFrame() where possible for better performance
       * @param {int|object} handle The callback function
       */
      const clearRequestInterval = function (handle) {
        window.cancelAnimationFrame ? window.cancelAnimationFrame(handle.value) : clearInterval(handle);
      };

      return {
        calcMaxHeight,
        removeClasses,
        addClasses,
        requestInterval,
        clearRequestInterval,
      };
    },

    /**
     *  Main Slider function
     */
    heroSlider() {
      const slider = {
        hero: document.querySelector("#hero-slider"),
        main: document.querySelector("#slides-main"),
        aux: document.querySelector("#slides-aux"),
        current: document.querySelector("#slider-nav .current"),
        handle: null,
        idle: true,
        activeIndex: -1,
        interval: 3500,
      };

      const setHeight = (holder, items) => {
        const h = this.utils().calcMaxHeight(items);
        holder.style.height = `${h}px`;
      };

      const leadingZero = function () {
        return arguments[1] < 10 ? "0" + arguments[1] : arguments[1];
      };

      const setCurrent = function () {
        slider.current.innerText = leadingZero`${slider.activeIndex + 1}`;
      };

      const changeSlide = (direction) => {
        slider.idle = false;
        slider.hero.classList.remove("prev", "next");
        if (direction == "next") {
          slider.activeIndex = (slider.activeIndex + 1) % slider.total;
          slider.hero.classList.add("next");
        } else {
          slider.activeIndex = (slider.activeIndex - 1 + slider.total) % slider.total;
          slider.hero.classList.add("prev");
        }

        //reset classes
        this.utils().removeClasses(slider.items, ["prev", "active"]);

        //set prev
        const prevItems = [...slider.items].filter((item) => {
          let prevIndex;
          if (slider.hero.classList.contains("prev")) {
            prevIndex = slider.activeIndex == slider.total - 1 ? 0 : slider.activeIndex + 1;
          } else {
            prevIndex = slider.activeIndex == 0 ? slider.total - 1 : slider.activeIndex - 1;
          }

          return item.dataset.index == prevIndex;
        });

        //set active
        const activeItems = [...slider.items].filter((item) => {
          return item.dataset.index == slider.activeIndex;
        });

        this.utils().addClasses(prevItems, ["prev"]);
        this.utils().addClasses(activeItems, ["active"]);
        setCurrent();

        const activeImageItem = slider.main.querySelector(".active");
        activeImageItem.addEventListener("transitionend", waitForIdle, {
          once: true,
        });
      };

      const stopAutoplay = () => {
        slider.autoplay = false;
        this.utils().clearRequestInterval(slider.handle);
      };

      const waitForIdle = function () {
        !slider.autoplay && autoplay(false); //restart
        slider.idle = true;
      };

      const wheelControl = function () {
        slider.hero.addEventListener("wheel", (e) => {
          if (slider.idle) {
            const direction = e.deltaY > 0 ? "next" : "prev";
            stopAutoplay();
            changeSlide(direction);
          }
        });
      };

      const autoplay = (initial) => {
        slider.autoplay = true;
        slider.items = slider.hero.querySelectorAll("[data-index]");
        slider.total = slider.items.length / 2;

        const loop = () => changeSlide("next");

        initial && requestAnimationFrame(loop);
        slider.handle = this.utils().requestInterval(loop, slider.interval);
      };

      const loaded = function () {
        slider.hero.classList.add("loaded");
      };

      const touchControl = function () {
        const touchStart = function (e) {
          slider.ts = parseInt(e.changedTouches[0].clientX);
          window.scrollTop = 0;
        };

        const touchMove = function (e) {
          slider.tm = parseInt(e.changedTouches[0].clientX);
          const delta = slider.tm - slider.ts;
          window.scrollTop = 0;

          if (slider.idle) {
            const direction = delta < 0 ? "next" : "prev";
            stopAutoplay();
            changeSlide(direction);
          }
        };

        slider.hero.addEventListener("touchstart", touchStart);
        slider.hero.addEventListener("touchmove", touchMove);
      };

      const start = function () {
        autoplay(true);
        wheelControl();
        window.innerWidth <= 1024 && touchControl();
        slider.aux.addEventListener("transitionend", loaded, {
          once: true,
        });
      };

      const loadingAnimation = function () {
        slider.hero.classList.add("ready");
        slider.current.addEventListener("transitionend", start, {
          once: true,
        });
      };

      const init = function () {
        setHeight(slider.aux, slider.aux.querySelectorAll(".slide-title"));
        loadingAnimation();
      };

      const resize = function () {
        setHeight(slider.aux, slider.aux.querySelectorAll(".slide-title"));
      };

      return {
        init,
        resize,
      };
    },
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
