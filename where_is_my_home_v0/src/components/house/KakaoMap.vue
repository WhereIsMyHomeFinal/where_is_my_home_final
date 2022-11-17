<template>
  <div>
    <div id="map"></div>
    <div id="searchBox" class="card">
      <b-tabs content-class="mt-3">
        <b-tab title="동 검색" active>

        </b-tab>
        <b-tab title="키워드 검색">
          
        </b-tab>
      </b-tabs>
    </div>
  </div>
</template>
<script>
export default {
  name: "KakaoMap",
  methods: {
    initMap() {
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div
          mapOption = {
            center: new kakao.maps.LatLng(37.564343, 126.947613), // 지도의 중심좌표
            level: 3, // 지도의 확대 레벨
          };

      this.map = new kakao.maps.Map(mapContainer, mapOption);
    },
  },
  mounted () {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement('script');
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        `http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${process.env.VUE_APP_KAKAOMAP_KEY}`;
      document.head.appendChild(script);
    }
  },
}
</script>
<style scoped>
#map {
  width: 100%;
  height: 90vh;
}
#searchBox {
  position: absolute;
  top: 20px;
  /* bottom : 10px; */
  left: 20px;
  width: 400px;
  /* height: 400px; */
  padding: 10px;
  z-index: 100;
  /* background-color:rgba(255, 244, 244, 0.8); */
  /* opacity: 0.5; */
  background-color: rgba( 255, 255, 255, 0.7 );
  overflow-y: auto;
}
</style>