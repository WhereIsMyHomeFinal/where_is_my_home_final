<template>
  <div>
    <div class="map_wrap">
      <div id="map"></div>
      <ul id="category">
        <li id="BK9" data-order="0">
          <span class="category_bg bank"></span>
          은행
        </li>
        <li id="MT1" data-order="1">
          <span class="category_bg mart"></span>
          마트
        </li>
        <li id="PM9" data-order="2">
          <span class="category_bg pharmacy"></span>
          약국
        </li>
        <li id="OL7" data-order="3">
          <span class="category_bg oil"></span>
          주유소
        </li>
        <li id="CE7" data-order="4">
          <span class="category_bg cafe"></span>
          카페
        </li>
        <li id="CS2" data-order="5">
          <span class="category_bg store"></span>
          편의점
        </li>
      </ul>
    </div>
    <div>
      <!-- <b-form-group id="radiobox" class="card" v-slot="{ ariaDescribedby }"> -->
        <b-form-radio-group
          id="radiobox"
          v-model="selected"
          :options="options"
          :aria-describedby="ariaDescribedby"
          name="radios-btn-default"
        ></b-form-radio-group>
      <!-- </b-form-group> -->
    </div>
    <div id="searchBox" class="card">
      <b-tabs content-class="mt-3">
        <b-tab title="동 검색" active>
          <dong-search @searched-houses="addMarkers" />
        </b-tab>
        <b-tab title="키워드 검색">
          <keyword-search @searched-houses="addMarkers" />
        </b-tab>
      </b-tabs>
    </div>
    <div id="showList" v-if="listVisible" class="card p-0">
      <div v-if="curIndex < 0">
        <div class="bg-white mb-2 bg-white">
          <div class="p-3 border-bottom d-flex justify-content-between align-items-center">
            <h4 class="m-0">매물 목록</h4>
          </div>
        </div>
        <div class="px-3 bg-white" v-for="(apt, index) in aptlist" :key="index">
          <div id="placesList" class="d-flex border-bottom py-3" @click="showHouseDetail(index)" 
            @mouseover="displayMouseInfo(index)" @mouseout="closeMouseInfo()">
            <div class="col-md-6 text-info">{{ apt.aptName }}</div>
            <div>
              <div>{{apt.dongName}}</div><br/>
              <div>평균 매매 가격 {{ apt.dealAmount }}</div>
            </div>
          </div>
        </div>
      </div>
      <div v-else>
        <div class="bg-white p-3 border-bottom d-flex justify-content-between align-items-center">
          <h4 class="m-0">{{ aptlist[curIndex].aptName }}</h4>
          <HeartBtn class="px-1" :enabled="aptlist[curIndex].liked" @changeHeartBtn="onLikedHouse" />
          <b-icon icon="arrow-left" scale="1" variant="secondary" @click="curIndex = -1;"></b-icon>
        </div>
          <b-tabs content-class="mt-3">
            <b-tab title="기본 정보" active>
              <div id="roadview" style="width: 100%; height: 300px"></div>
              <!-- contents -->
              <div class="px-3">
                <div class="border-bottom d-flex py-2">
                  <div class="text-secondary w-25">주소</div>
                  <div>{{ aptlist[curIndex].dongName }}</div>
                </div>
                <div class="d-flex py-2">
                  <div class="text-secondary w-25">건축년도</div>
                  <div>{{ aptlist[curIndex].buildYear }}</div>
                </div>
                <div class="d-flex py-2">
                  <div class="text-secondary w-25">거래가격</div>
                  <div>{{ dealInfo.dealAmount }}</div>
                </div>
                <div class="d-flex py-2">
                  <div class="text-secondary w-25">면적</div>
                  <div>{{ dealInfo.area }}</div>
                </div>
                <div class="d-flex py-2">
                  <div class="text-secondary w-25">층수</div>
                  <div>{{ dealInfo.floor }}</div>
                </div>
              </div>
            </b-tab>
            <b-tab title="리뷰">
              <!-- 거주민 리뷰 -->
              <div class="bg-white mb-2">
                <div class="d-flex justify-content-between align-items-center">
                  <h4 class="p-3 m-0">리뷰 총점</h4>
                  <!-- <i v-if="isAuth&&level==2" @click="showReviewInsertModal" class="bi bi-plus-circle px-3 cursor-pointer"></i> -->
                </div>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="border-bottom py-2 text-danger">
                    <div class="w-20">추천점수</div>
                    <div>{{sum_recommend}}</div>
                    <div>
                      <StarRating
                        v-model="sum_recommend"
                        active-color="#dc3545"
                        :read-only="true"
                        :show-rating="false"
                        :rounded-corners="true"
                        :star-size="10"
                        :star-points="[23, 2, 14, 17, 0, 19, 10, 34, 7, 50, 23, 43, 38, 50, 36, 34, 46, 19, 31, 17]"
                      ></StarRating>
                    </div>
                  </div>
                  <div class="border-bottom py-2">
                    <div class="w-20 text-secondary">교통요건</div>
                    <div>{{sum_traffic}}</div>
                    <div>
                      <StarRating
                        v-model="sum_traffic"
                        :read-only="true"
                        :show-rating="false"
                        :rounded-corners="true"
                        :star-size="10"
                        :star-points="[23, 2, 14, 17, 0, 19, 10, 34, 7, 50, 23, 43, 38, 50, 36, 34, 46, 19, 31, 17]"
                      ></StarRating>
                    </div>
                  </div>
                  <div class="border-bottom py-2">
                    <div class="w-20 text-secondary">거주환경</div>
                    <div>{{sum_living}}</div>
                    <div>
                      <StarRating
                        v-model="sum_living"
                        :read-only="true"
                        :show-rating="false"
                        :rounded-corners="true"
                        :star-size="10"
                        :star-points="[23, 2, 14, 17, 0, 19, 10, 34, 7, 50, 23, 43, 38, 50, 36, 34, 46, 19, 31, 17]"
                      ></StarRating>
                    </div>
                  </div>
                  <div class="border-bottom py-2">
                    <div class="w-20 text-secondary">주변환경</div>
                    <div>{{sum_surround}}</div>
                    <div>
                      <StarRating
                        v-model="sum_surround"
                        :read-only="true"
                        :show-rating="false"
                        :rounded-corners="true"
                        :star-size="10"
                        :star-points="[23, 2, 14, 17, 0, 19, 10, 34, 7, 50, 23, 43, 38, 50, 36, 34, 46, 19, 31, 17]"
                      ></StarRating>
                    </div>
                  </div>
                </div>
                <div class="d-flex justify-content-between align-items-center">
                  <h4 class="p-3 m-0">거주민 리뷰</h4>
                  <!-- <i v-if="isAuth&&level==2" @click="showReviewInsertModal" class="bi bi-plus-circle px-3 cursor-pointer"></i> -->
                </div>
                <div v-if="reviewList.length == 0" class="p-3 border-top">
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
                      <h5 class="m-0">{{ review.userName }}</h5>
                      <div class="text-secondary" style="font-size: 0.9rem">{{ review.registDate }} 가입</div>
                    </div>
                  </div>
                  <div class="px-3">
                    <div class="border-bottom d-flex py-2 text-danger">
                      <div class="w-25">추천점수</div>
                      <div>
                        <StarRating
                          v-model="review.recommendScore"
                          active-color="#dc3545"
                          :read-only="true"
                          :show-rating="false"
                          :rounded-corners="true"
                          :star-size="20"
                          :star-points="[23, 2, 14, 17, 0, 19, 10, 34, 7, 50, 23, 43, 38, 50, 36, 34, 46, 19, 31, 17]"
                        ></StarRating>
                      </div>
                    </div>
                    <div class="border-bottom d-flex py-2">
                      <div class="text-secondary w-25">교통요건</div>
                      <div>
                        <StarRating
                          v-model="review.trafficScore"
                          :read-only="true"
                          :show-rating="false"
                          :rounded-corners="true"
                          :star-size="20"
                          :star-points="[23, 2, 14, 17, 0, 19, 10, 34, 7, 50, 23, 43, 38, 50, 36, 34, 46, 19, 31, 17]"
                        ></StarRating>
                      </div>
                    </div>
                    <div class="border-bottom d-flex py-2">
                      <div class="text-secondary w-25">거주환경</div>
                      <div>
                        <StarRating
                          v-model="review.livingScore"
                          :read-only="true"
                          :show-rating="false"
                          :rounded-corners="true"
                          :star-size="20"
                          :star-points="[23, 2, 14, 17, 0, 19, 10, 34, 7, 50, 23, 43, 38, 50, 36, 34, 46, 19, 31, 17]"
                        ></StarRating>
                      </div>
                    </div>
                    <div class="border-bottom d-flex py-2">
                      <div class="text-secondary w-25">주변환경</div>
                      <div>
                        <StarRating
                          v-model="review.surroundScore"
                          :read-only="true"
                          :show-rating="false"
                          :rounded-corners="true"
                          :star-size="20"
                          :star-points="[23, 2, 14, 17, 0, 19, 10, 34, 7, 50, 23, 43, 38, 50, 36, 34, 46, 19, 31, 17]"
                        ></StarRating>
                      </div>
                    </div>
                    <div class="pt-2 text-secondary">종합의견</div>
                    <div class="py-2">
                      <h5>{{ review.comment }}</h5>
                    </div>
                  </div>
                </div>
              </div>
            </b-tab>
          </b-tabs>
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
import KeywordSearch from "@/components/house/tabbox/KeywordSearch.vue";
import StarRating from "vue-star-rating";
import { nextTick } from 'vue'
import HeartBtn from "@/components/icon/HeartBtn.vue";
import { mapState } from 'vuex';

const memberStore = "memberStore";

export default {
  name: "KakaoMap",
  components: {
    DongSearch,
    KeywordSearch,
    StarRating,
    HeartBtn,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      listVisible: false,
      dealInfo: {},
      aptlist: [],
      markers: [],
      reviewList: [],
      currCategory: "",
      curIndex : -1,
      sum_recommend: 0.0,
      sum_traffic: 0.0,
      sum_living: 0.0,
      sum_surround: 0.0,
      selected: "recommend",
      options: [
        { value: "recommend", text: "추천점수"},
        { value: "traffic", text: "교통요건"},
        { value: "living", text: "거주환경"},
        { value: "surround", text: "주변환경"},
      ],
      infowindow: {},
    };
  },
  methods: {
    initMap() {
      console.log("initmap");
      this.placeOverlay = new kakao.maps.CustomOverlay({ zIndex: 1 });
      this.contentNode = document.createElement("div"); // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다

      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(37.5642135, 127.001698), // 지도의 중심좌표
          level: 7, // 지도의 확대 레벨
        };

      this.map = new kakao.maps.Map(mapContainer, mapOption);
      this.ps = new kakao.maps.services.Places(this.map);
      kakao.maps.event.addListener(this.map, "idle", this.searchPlaces);
      this.contentNode.className = "placeinfo_wrap";
      this.addEventHandle(this.contentNode, "mousedown", kakao.maps.event.preventMap);
      this.addEventHandle(this.contentNode, "touchstart", kakao.maps.event.preventMap);
      this.placeOverlay.setContent(this.contentNode);
      this.addCategoryClickEvent();
      this.infowindow = new kakao.maps.InfoWindow({zIndex:1});
    },
    addMarkers(aptlist) {
      this.curIndex = -1;
      console.log("addmarkers");
      // this.initMap();
      this.removeMarker();
      this.listVisible = false;
      // console.log(aptlist[0]);
      this.markers = [];
      this.aptlist = aptlist;
      let bounds = new kakao.maps.LatLngBounds();
      this.listVisible = true;
      aptlist.forEach(({ lat, lng }, index) => {
        // console.log(`forEach ${index}`)
        let markerPosition = new kakao.maps.LatLng(lat, lng);
        this.addMarkerByOne(markerPosition, index);
        bounds.extend(markerPosition);
      });
      if (aptlist.length > 0) {
        this.addInfoWindow();
      }
      this.map.setBounds(bounds);
    },
    addMarkerByOne(markerPosition, index) {
      console.log("addmarkerbyone");
      let marker = new kakao.maps.Marker({
        position: markerPosition,
      });
      let $this = this;
      kakao.maps.event.addListener(marker, "click", function () {
        $this.showHouseDetail(index);
      });
      this.markers.push(marker);
      marker.setMap(this.map);
    },
    addInfoWindow() {
      console.log("addiw");
      this.markers.forEach((marker, index) => {
        let item = this.aptlist[index];
        let infoContents = `<div style="width:150px;text-align:center;padding:6px 0;">${item.aptName}</div>`;
        let infoWindow = new kakao.maps.InfoWindow({
          content: infoContents,
        });
        let $this = this;
        kakao.maps.event.addListener(marker, "mouseover", function () {
          infoWindow.open($this.map, marker);
        });
        kakao.maps.event.addListener(marker, "mouseout", function () {
          infoWindow.close();
        });
      });
    },
    async showHouseDetail(index) {
      this.sum_recommend = 0.0;
      this.sum_traffic = 0.0;
      this.sum_living = 0.0;
      this.sum_surround = 0.0;

      console.log("showhousedetail");
      if (!this.listVisible) {
        this.listVisible = true;
      }
      this.curIndex = index;
      await nextTick();
      const no = this.aptlist[index].no;
      const aptCode = this.aptlist[index].aptCode;
      http.get(`/house-deals/${this.userInfo.userIdx}/${no}`).then(({ data }) => {
        console.log(data);
        this.dealInfo = data;
      });
      http.get(`/reviews/${aptCode}`).then(({ data }) => {
        // console.log(data.recommendScore, data.trafficScore, data.livingScore, data.surroundScore);
        this.reviewList = data;
        this.reviewList.forEach((review) => {
          this.sum_recommend += review.recommendScore;
          this.sum_traffic += review.trafficScore;
          this.sum_living += review.livingScore;
          this.sum_surround += review.surroundScore;
        });
        this.sum_recommend /= this.reviewList.length;
        this.sum_traffic /= this.reviewList.length;
        this.sum_living /= this.reviewList.length;
        this.sum_surround /= this.reviewList.length;

        this.sum_recommend = this.deal_NaN(this.sum_recommend);
        this.sum_traffic = this.deal_NaN(this.sum_traffic);
        this.sum_living = this.deal_NaN(this.sum_living);
        this.sum_surround = this.deal_NaN(this.sum_surround);
      });
      var roadviewContainer = document.getElementById("roadview"); //로드뷰를 표시할 div
      var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
      var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체
      var position = new kakao.maps.LatLng(this.aptlist[index].lat, this.aptlist[index].lng);
      // var position = new kakao.maps.LatLng(33.450802, 126.570667);

      // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
      roadviewClient.getNearestPanoId(position, 50, function (panoId) {
        roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
      });
    },
    deal_NaN(num) {
      if (isNaN(num)) return 0;
      else return num;
    },
    removeMarker() {
      for (var i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(null);
      }
      this.markers = [];
    },
    addEventHandle(target, type, callback) {
      if (target.addEventListener) {
        target.addEventListener(type, callback);
      } else {
        target.attachEvent("on" + type, callback);
      }
    },
    searchPlaces() {
      if (!this.currCategory) {
        return;
      }
      // 커스텀 오버레이를 숨깁니다
      this.placeOverlay.setMap(null);
      // 지도에 표시되고 있는 마커를 제거합니다
      // this.removeMarker();
      this.ps.categorySearch(this.currCategory, this.placesSearchCB, { useMapBounds: true });
    },
    placesSearchCB(data, status, pagination) {
      if (status === kakao.maps.services.Status.OK) {
        // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
        this.displayPlaces(data);
        displayPagination(pagination);
        // } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        //   // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요
        // } else if (status === kakao.maps.services.Status.ERROR) {
        //   // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
      }
    },
    displayPlaces(places) {
      // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
      // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
      var order = document.getElementById(this.currCategory).getAttribute("data-order");

      for (var i = 0; i < places.length; i++) {
        // 마커를 생성하고 지도에 표시합니다
        var marker = this.addMarker(new kakao.maps.LatLng(places[i].y, places[i].x), order);
        // 마커와 검색결과 항목을 클릭 했을 때
        // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
        (function (marker, place, prethis) {
          kakao.maps.event.addListener(marker, "click", function () {
            prethis.displayPlaceInfo(place);
          });
        })(marker, places[i], this);
      }
    },
    addMarker(position, order) {
      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png", // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(27, 28), // 마커 이미지의 크기
        imgOptions = {
          spriteSize: new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
          spriteOrigin: new kakao.maps.Point(46, order * 36), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
          offset: new kakao.maps.Point(11, 28), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
        marker = new kakao.maps.Marker({
          position: position, // 마커의 위치
          image: markerImage,
        });

      marker.setMap(this.map); // 지도 위에 마커를 표출합니다
      this.markers.push(marker); // 배열에 생성된 마커를 추가합니다

      return marker;
    },
    displayPlaceInfo(place) {
      var content =
        '<div class="placeinfo">' +
        '   <a class="title" href="' +
        place.place_url +
        '" target="_blank" title="' +
        place.place_name +
        '">' +
        place.place_name +
        "</a>";

      if (place.road_address_name) {
        content +=
          '    <span title="' +
          place.road_address_name +
          '">' +
          place.road_address_name +
          "</span>" +
          '  <span class="jibun" title="' +
          place.address_name +
          '">(지번 : ' +
          place.address_name +
          ")</span>";
      } else {
        content += '    <span title="' + place.address_name + '">' + place.address_name + "</span>";
      }

      content += '    <span class="tel">' + place.phone + "</span>" + "</div>" + '<div class="after"></div>';

      this.contentNode.innerHTML = content;
      this.placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
      this.placeOverlay.setMap(this.map);
    },
    addCategoryClickEvent() {
      var category = document.getElementById("category"),
        children = category.children;
      let compThis = this;
      for (var i = 0; i < children.length; i++) {
        children[i].addEventListener("click", function () {
          var id = this.id,
            className = this.className;
          console.log(this);

          compThis.placeOverlay.setMap(null);
          if (className === "on") {
            compThis.currCategory = "";
            compThis.changeCategoryClass();
            compThis.removeMarker();
          } else {
            compThis.currCategory = id;
            compThis.changeCategoryClass(this);
            compThis.searchPlaces();
          }
        });
      }
    },
    changeCategoryClass(el) {
      var category = document.getElementById("category"),
        children = category.children,
        i;

      for (i = 0; i < children.length; i++) {
        children[i].className = "";
      }

      if (el) {
        el.className = "on";
      }
    },
    onLikedHouse({ enabled }) {
      if (enabled) {
        http.post(`/like-deals/${this.userInfo.userIdx}/${this.aptlist[this.curIndex].no}`)
        .then(({ data }) => {
          this.aptlist[this.curIndex].liked = enabled;
          // console.log(`enabled: ${enabled}, liked: ${this.aptlist[this.curIndex].liked}`);
          // if (data.result == 'login') {
          //   this.$swal('세션이 만료되었거나, 로그인되지 않았습니다. 로그인 페이지로 이동합니다.', { icon: 'warning' })
          //     .then(() => {
          //       this.SET_USER_LOGOUT();
          //       this.$router.push('/user/login');
          //     })
          // }
        }) 
        .catch(error => this.$swal('서버에 문제가 발생하였습니다.', { icon: 'error' }))
      } else {
        http.delete(`/like-deals/${this.userInfo.userIdx}/${this.aptlist[this.curIndex].no}`)
        .then(({ data }) => {
          this.aptlist[this.curIndex].liked = enabled;
          // console.log(`enabled: ${enabled}, liked: ${this.aptlist[this.curIndex].liked}`);
            // if (data.result == 'login') {
            //   this.$swal('세션이 만료되었거나, 로그인되지 않았습니다. 로그인 페이지로 이동합니다.', { icon: 'warning' })
            //     .then(() => {
            //       this.SET_USER_LOGOUT();
            //       this.$router.push('/user/login');
            //     })
            // }
        })
        .catch(error => this.$swal('서버에 문제가 발생하였습니다.', { icon: 'error' }))
      }
    },
    displayMouseInfo(index) {
      this.infowindow = new kakao.maps.InfoWindow({zIndex:1});
      var content = '<div style="padding:5px;z-index:1;">' + this.aptlist[index].aptName + '</div>';
      this.infowindow.setContent(content);
      this.infowindow.open(this.map, this.markers[index]);
    },
    closeMouseInfo() {
      this.infowindow.close();
    },
  },
  mounted() {
    console.log("mounted");
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = `http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${process.env.VUE_APP_KAKAOMAP_KEY}`;
      document.head.appendChild(script);
    }
  },
};
</script>
<style scoped>
#map {
  width: 100%;
  height: 91vh;
}
#radiobox {
  position: absolute;
  top: 285px;
  left: 10px;
  width: 495px;
  font-size: 20px;
  border-radius: 10px;
  /* line-height: 2rem; */
  padding: 10px;
  background-color: rgba(255, 255, 255, 0.7);
  z-index: 1;
  /* overflow-y: auto; */
}
#searchBox {
  position: absolute;
  top: 150px;
  /* bottom : 10px; */
  left: 10px;
  width: 400px;
  /* height: 400px; */
  padding: 10px;
  z-index: 100;
  /* background-color:rgba(255, 244, 244, 0.8); */
  /* opacity: 0.5; */
  background-color: rgba(255, 255, 255, 0.7);
  overflow-y: auto;
}
#showList {
  position: absolute;
  top: 340px;
  bottom: 10px;
  left: 10px;
  /* right: 1505px; */
  width: 400px;
  padding: 10px;
  z-index: 100;
  background-color:rgba(255, 255, 255, 0.7);
  /* opacity: 0.5; */
  overflow-y: auto;
}
.text-secondary {
  color: gray;
}
.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
  font-size: 12px;
}
.map_wrap {
  position: relative;
  width: 100%;
  height: 350px;
}
#category {
  position: absolute;
  top: 10px;
  left: 10px;
  border-radius: 5px;
  border: 1px solid #909090;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
  background: #fff;
  overflow: hidden;
  z-index: 2;
}
#category li {
  float: left;
  list-style: none;
  width: 50px;
  border-right: 1px solid #acacac;
  padding: 6px 0;
  text-align: center;
  cursor: pointer;
}
#category li.on {
  background: #eee;
}
#category li:hover {
  background: #ffe6e6;
  border-left: 1px solid #acacac;
  margin-left: -1px;
}
#category li:last-child {
  margin-right: 0;
  border-right: 0;
}
#category li span {
  display: block;
  margin: 0 auto 3px;
  width: 27px;
  height: 28px;
}
#category li .category_bg {
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png) no-repeat;
}
#category li .bank {
  background-position: -10px 0;
}
#category li .mart {
  background-position: -10px -36px;
}
#category li .pharmacy {
  background-position: -10px -72px;
}
#category li .oil {
  background-position: -10px -108px;
}
#category li .cafe {
  background-position: -10px -144px;
}
#category li .store {
  background-position: -10px -180px;
}
#category li.on .category_bg {
  background-position-x: -46px;
}
</style>
<style>
.placeinfo_wrap {
  position: absolute;
  bottom: 28px;
  left: -150px;
  width: 300px;
}
.placeinfo {
  position: relative;
  width: 100%;
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  padding-bottom: 10px;
  background: #fff;
}
.placeinfo:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}
.placeinfo_wrap .after {
  content: "";
  position: relative;
  margin-left: -12px;
  left: 50%;
  width: 22px;
  height: 12px;
  background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
}
.placeinfo a,
.placeinfo a:hover,
.placeinfo a:active {
  color: #fff;
  text-decoration: none;
}
.placeinfo a,
.placeinfo span {
  display: block;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
.placeinfo span {
  margin: 5px 5px 0 5px;
  cursor: default;
  font-size: 13px;
}
.placeinfo .title {
  font-weight: bold;
  font-size: 14px;
  border-radius: 6px 6px 0 0;
  margin: -1px -1px 0 -1px;
  padding: 10px;
  color: #fff;
  background: #17a2b8;
  background: #17a2b8 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px
    center;
}
.placeinfo .tel {
  color: #0f7833;
}
.placeinfo .jibun {
  color: #999;
  font-size: 11px;
  margin-top: 0;
}
</style>
