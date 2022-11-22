<template>
  <div>
    <div id="map"></div>
    <div id="searchBox" class="card">
      <b-tabs content-class="mt-3">
        <b-tab title="동 검색" active>
          <dong-search @searched-houses="addMarkers"/>
        </b-tab>
        <b-tab title="키워드 검색">
          <keyword-search @searched-houses="addMarkers"/>
        </b-tab>
      </b-tabs>
    </div>
    <div v-if="listVisible" id="showList" class="card p-0 bg-secondary">
      <div class="bg-white mb-2">
        <div class="p-3 border-bottom d-flex justify-content-between align-items-center">
          <h4 class="m-0">{{ aptlist[curIndex].aptName }}</h4>
          <!-- <HeartBtn v-if="isAuth&&level==2" class="px-1" :enabled="aptlist[curIndex].bookmark" @changeHeartBtn="onBookmarkHouse" /> -->
        </div>
        <!-- contents -->
        <div class="px-3">
          <div class="border-bottom d-flex py-2">
            <div class="text-secondary w-25">주소</div>
            <div>{{ aptlist[curIndex].dongName }}</div>
          </div>
          <div class="d-flex py-2">
            <div class="text-secondary w-25">건축년도</div>
            <div>{{ aptlist[curIndex].buildYear}}</div>
          </div>
        </div>
      </div>
      <!-- 거주민 리뷰 -->
      <div class="bg-white mb-2">
        <div class="d-flex justify-content-between align-items-center">
          <h5 class="p-3 m-0">거주민 리뷰</h5>
          <!-- <i v-if="isAuth&&level==2" @click="showReviewInsertModal" class="bi bi-plus-circle px-3 cursor-pointer"></i> -->
        </div>

        <div v-if="reviewList.length==0" class="p-3 border-top">
          <div>등록된 리뷰가 없습니다.</div>
        </div>
        <!-- 등록 리뷰 있을 때 v-for 속성 추가-->
        <div v-else v-for="(review, index) in reviewList" :key="index">
          <div class="border-top border-bottom d-flex align-items-center p-2">
            <div class="text-secondary ps-2 pe-3">
              <!-- <img v-if="review.userProfileImage" class="avatar rounded-circle" width=25px :src="review.userProfileImage"> -->
              <!-- <img v-else class="avatar rounded-circle" width=25px src="../assets/images/profile_av.png"> -->
            </div>
            <div class="d-flex flex-column">
              <h6 class="m-0">{{ review.userName }}</h6>
              <div class="text-secondary" style="font-size: 0.9rem;">{{ review.registDate }} 가입</div>
            </div>
          </div>
          <div class="px-3">
            <div class="border-bottom d-flex py-2 text-danger">
              <div class="w-25">추천점수</div>
              <div>
                <StarRating v-model="review.recommendScore" active-color="#dc3545" :read-only="true" :show-rating="false" :rounded-corners="true" :star-size="20" :star-points="[23,2, 14,17, 0,19, 10,34, 7,50, 23,43, 38,50, 36,34, 46,19, 31,17]"></StarRating>
              </div>
            </div>
            <div class="border-bottom d-flex py-2">
              <div class="text-secondary w-25">교통요건</div>
              <div>
                <StarRating v-model="review.trafficScore" :read-only="true" :show-rating="false" :rounded-corners="true" :star-size="20" :star-points="[23,2, 14,17, 0,19, 10,34, 7,50, 23,43, 38,50, 36,34, 46,19, 31,17]"></StarRating>
              </div>
            </div>
            <div class="border-bottom d-flex py-2">
              <div class="text-secondary w-25">거주환경</div>
              <div>
                <StarRating v-model="review.livingScore" :read-only="true" :show-rating="false" :rounded-corners="true" :star-size="20" :star-points="[23,2, 14,17, 0,19, 10,34, 7,50, 23,43, 38,50, 36,34, 46,19, 31,17]"></StarRating>
              </div>
            </div>
            <div class="border-bottom d-flex py-2">
              <div class="text-secondary w-25">주변환경</div>
              <div>
                <StarRating v-model="review.surroundScore" :read-only="true" :show-rating="false" :rounded-corners="true" :star-size="20" :star-points="[23,2, 14,17, 0,19, 10,34, 7,50, 23,43, 38,50, 36,34, 46,19, 31,17]"></StarRating>
              </div>
            </div>
            <div class="pt-2 text-secondary">종합의견</div>
            <div class="py-2"><h6>{{ review.comment }}</h6></div>
          </div>
        </div>
      </div> 
      <!-- 실거래가 -->
      <div class="bg-white mb-2">
        <div class="border-bottom"><h5 class="p-3 m-0">실거래가</h5></div>
        <div>
          <table class="w-100">
            <thead class="bg-secondary text-white">
              <tr>
                <!-- <td class="ps-3 py-1">거래일</td> -->
                <td>거래가격</td>
                <td>면적</td>
                <td>층수</td>
              </tr>
            </thead>
            <tbody class="px-2">
              <tr class="border-bottom">
                <!-- <td class="ps-3 py-2">{{dealInfo.dealYear}}</td> -->
                <td>{{dealInfo.dealAmount}}</td>
                <td>{{dealInfo.area}}</td>
                <td>{{dealInfo.floor}}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <!-- 매물정보 -->
      <!-- <div class="bg-white mb-2">
        <div class="border-bottom"><h5 class="p-3 m-0">매물 정보</h5></div>
        <div>
          <table class="w-100">
            <thead class="bg-secondary text-white">
              <tr>
                <td class="ps-3 py-1">타입</td>
                <td class="w-50">제목</td>
                <td>거래가격</td>
                <td></td>
              </tr>
            </thead>
            <tbody class="px-2">
              <tr v-if="ongoingList.length==0" class="border-bottom">
                <td colspan="3" class="ps-3 py-2">등록된 매물이 없습니다.</td>
              </tr>
              <tr v-else v-for="(item, index) in ongoingList" :key="index" class="border-bottom">
                <td class="ps-3 py-2">{{ item.type }}</td>
                <td>{{ item.title }}</td>
                <td>{{ item.dealAmount }}</td>
                <td><HeartBtn :enabled="item.bookmark" :index="index" @changeHeartBtn="onBookmarkOngoing" /></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div> -->
    </div>
  </div>
</template>
<script>
import http from "@/api/http.js";
import DongSearch from "@/components/house/tabbox/DongSearch.vue";
import KeywordSearch from '@/components/house/tabbox/KeywordSearch.vue';
import StarRating from 'vue-star-rating';

export default {
  name: "KakaoMap",
  components: {
    DongSearch,
    KeywordSearch,
    StarRating,
  },
  data() {
    return {
      listVisible: false,
      dealInfo: {},
      aptlist: [],
      markers: [],
      reviewList: [],
    };
  },
  methods: {
    initMap() {
      console.log("initmap");
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div
          mapOption = {
            center: new kakao.maps.LatLng(37.5642135, 127.0016980), // 지도의 중심좌표
            level: 7, // 지도의 확대 레벨
          };

      this.map = new kakao.maps.Map(mapContainer, mapOption);
    },
    addMarkers(aptlist) {
      console.log("addmarkers");
      // this.initMap();
      this.listVisible = false;
      // console.log(aptlist[0]);
      this.aptlist = aptlist;
      this.markers = [];
      let bounds = new kakao.maps.LatLngBounds();
      
      aptlist.forEach(({ lat, lng }, index) => {
        // console.log(`forEach ${index}`)
        let markerPosition  = new kakao.maps.LatLng(lat, lng); 
        this.addMarkerByOne(markerPosition, index);
        bounds.extend(markerPosition);
      });
      if (aptlist.length > 0)  this.addInfoWindow();
      this.map.setBounds(bounds);
    },
    addMarkerByOne(markerPosition, index) {
      console.log("addmarkerbyone");
      let marker = new kakao.maps.Marker({
        position: markerPosition
      });
      let $this = this;
      kakao.maps.event.addListener(marker, 'click', function() {
        $this.showHouseDetail(index);
      });
      this.markers.push(marker);
      marker.setMap(this.map);
    },
    addInfoWindow() {
      console.log('addiw')
      this.markers.forEach((marker, index) => {
        let item = this.aptlist[index];
        let infoContents = `<div style="width:150px;text-align:center;padding:6px 0;">${item.aptName}</div>`;
        let infoWindow = new kakao.maps.InfoWindow({
            content: infoContents
        });
        let $this = this;
        kakao.maps.event.addListener(marker, 'mouseover', function() {
          infoWindow.open($this.map, marker);
        });
        kakao.maps.event.addListener(marker, 'mouseout', function() {
          infoWindow.close();
        });
      });
    },
    showHouseDetail(index) {
      console.log("showhousedetail");
      this.curIndex = index;
      const no = this.aptlist[index].no;
      const aptCode = this.aptlist[index].aptCode;
      http.get(`/house-deals/${no}`)
      .then(({ data }) => {
        console.log(data);
        this.dealInfo = data;
      });
      http.get(`/reviews/${aptCode}`)
      .then(({ data }) => {
        this.reviewList = data;
      });
      // this.getHouseDeal(no);
      // this.getOngoingList(no);
      // this.getHouseReview(no);
      if (!this.listVisible) this.listVisible = true;
    },
  },
  mounted () {
    console.log("mounted");
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
  height: 91vh;
}
#searchBox {
  position: absolute;
  top: 100px;
  /* bottom : 10px; */
  left: 15px;
  width: 400px;
  /* height: 400px; */
  padding: 10px;
  z-index: 100;
  /* background-color:rgba(255, 244, 244, 0.8); */
  /* opacity: 0.5; */
  background-color: rgba( 255, 255, 255, 0.7 );
  overflow-y: auto;
}
#showList {
  position: absolute;
  top: 235px;
  bottom : 20px;
  right: 1505px;
  width: 400px;
  padding: 10px;
  z-index: 100;
  /* background-color:rgba(255, 244, 244, 0.8); */
  /* opacity: 0.5; */
  overflow-y: auto;
}
</style>