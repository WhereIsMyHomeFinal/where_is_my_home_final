<template>
  <div class="container">
    <h3 class="text-center mt-5 mb-3" style="color: #5accff"><strong>아파트 실거래가를 조회해보세요!</strong></h3>
    <div class="row col-md-12 justify-content-center mb-2">
      <div class="form-group col-md-2" style="color: #5accff">
        <select class="form-select bg-secondary text-light" id="sido">
          <option value="" style="color: #5accff">시도선택</option>
        </select>
      </div>
      <div class="form-group col-md-2">
        <select class="form-select bg-secondary text-light" id="gugun">
          <option value="" style="color: #5accff">구군선택</option>
        </select>
      </div>
      <div class="form-group col-md-2">
        <select class="form-select bg-secondary text-light" id="dong" name="dong">
          <option value="" style="color: #5accff">동선택</option>
        </select>
      </div>
      <div class="form-group col-md-2">
        <!--  요기 아파트명 검색하는 부분인듯? -->
        <input type="text" name="aptName" id="aptName" value="" />
      </div>
      <div class="form-group col-md-4">
        <button
          type="button"
          id="list-btn2"
          class="btn btn-outline-info"
          style="outline-color: aliceblue"
        >실거래가 조회하기</button>
            
        <button
          type="button"
          id="add-btn"
          class="btn btn-outline-info"
          style="outline-color: aliceblue"
        >관심지역 추가</button>
      </div>
    </div>
    
    <div class="row">
      <div class="col-md-6">
        <kakaomap></kakaomap>
      </div>
      <div class="col-md-6">
        <table
          class="table table-hover text-center"
          style="overflow: auto; height: 800px"
        >
          <thead>
          <tr style="color: #5accff">
            <th class="info">아파트이름</th>
            <th class="info">거래금액</th>
            <th class="info">전용면적</th>
            <th class="info">법정동</th>
            <th class="info">층</th>
            <th class="info">건축년도</th>
          </tr>
          </thead>
          
          <tbody id="aptlist"></tbody>
        </table>
      </div>
    </div>
  </div>
</template>
<script>
import kakaomap from "@/components/aptlist/AptlistKakaomap.vue"
export default {
  name: "AppAptlist",
  components: {
    kakaomap,
  },
}
function displayMarkers(positions){
  if(positions.length === 0) {
    let tbody = document.querySelector("#aptlist");
    let tr = document.createElement("tr");

    let emptyTd = document.createElement("td");
    emptyTd.setAttribute("colspan", "6");
    emptyTd.appendChild(document.createTextNode("검색된 아파트가 없습니다."));
    tr.appendChild(emptyTd);
    tbody.appendChild(tr);
    return;
  }
  var defaultLatLng = positions[0].latlng; // 멀티캠퍼스
  
  // 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
  var bounds = new kakao.maps.LatLngBounds();    
  
  var mapContainer = document.getElementById("map"), // 지도를 표시할 div
    mapOption = {
      center: defaultLatLng, // 지도의 중심좌표
      level: 3, // 지도의 확대 레벨
    };

  // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
  var map = new kakao.maps.Map(mapContainer, mapOption);

  for (var i = 0; i < positions.length; i++) {
      
      // 마커를 생성합니다
      var marker = new kakao.maps.Marker({
          map: map, // 마커를 표시할 지도
          position: positions[i].latlng, // 마커를 표시할 위치
          title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
      });
      marker.setMap(map);
    // LatLngBounds 객체에 좌표를 추가합니다
      bounds.extend(positions[i].latlng);
  }
  map.setBounds(bounds);
  /* // 마커가 표시될 위치입니다
  var markerPosition = defaultLatLng;

  // 마커를 생성합니다
  var marker = new kakao.maps.Marker({
    position: markerPosition,
  }); */

  // 마커가 지도 위에 표시되도록 설정합니다
  // marker.setMap(map); 
}
var default_positions = [{title: "역삼멀티캠퍼스", latlng: new kakao.maps.LatLng(37.5013067, 127.0396596)}];
var aptName = document.getElementById("aptName").value;
var dong = document.querySelector("#dong").value;
console.log(aptName + " " + dong);
if(aptName === "" && dong === "")	displayMarkers(default_positions);
</script>
<style scoped>
  
</style>