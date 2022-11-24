<template>
  <div>
    <b-tabs content-class="mt-3">
      <b-tab title="프로필" active>
        <!-- <h3 id="title">프로필</h3> -->
        <b-card no-body class="card-profile" alt="Image placeholder" img-top>
          <b-row class="justify-content-center">
            <b-col class="order-lg-2">
              <b-img class="mt-5" :src="require('@/assets/profile_01.png')" rounded="circle" />
            </b-col>
          </b-row>

          <!-- <b-card-header class="text-center border-0 pt-8 pt-md-4 pb-0 pb-md-4">
          <div class="d-flex justify-content-between">
            <a href="#" class="btn btn-sm btn-info mr-4">EDIT</a>
            <a href="#" class="btn btn-sm btn-info float-right">EDIT</a>
          </div>
          <a href="#" class="btn btn-sm btn-info float-right">EDIT</a>
        </b-card-header> -->

          <b-card-body class="mt-4pt-0">
            <div class="text-center">
              <h5 class="h2">
                <span class="font-weight-bold">{{ userInfo.username }} ({{ userInfo.userid }})</span>
              </h5>
              <!-- <div class="h5 font-weight-300">
              <i class="ni location_pin mr-2"></i>Bucharest, Romania
            </div>
            <div class="h5 mt-4">
              <i class="ni business_briefcase-24 mr-2"></i>Solution Manager - Creative Tim Officer
            </div> -->
              <div style="font-size: 1.2em">
                {{ userInfo.email }}
              </div>
              <div class="mt-2" style="font-size: 0.8em">가입일: {{ userInfo.joindate }}</div>
              <!-- <hr class="my-4"> -->
            </div>
            <b-row>
              <b-col>
                <div class="card-profile-stats d-flex justify-content-center md-5">
                  <div>
                    <span class="heading">22</span>
                    <span class="description">찜한 매물</span>
                  </div>
                  <div>
                    <span class="heading">10</span>
                    <span class="description">리뷰</span>
                  </div>
                  <div>
                    <span class="heading">89</span>
                    <span class="description">친구</span>
                  </div>
                </div>
                <a href="#" class="btn btn-sm btn-info float-right">EDIT</a>
              </b-col>
            </b-row>
          </b-card-body>
        </b-card>
      </b-tab>
      <b-tab title="찜한 매물">
        <!-- <h3 id="title">찜한 매물</h3> -->
        <b-card no-body class="card-profile" alt="Image placeholder" img-top>
          <div class="section" style="margin: 10px">
            <div v-for="likedeal in likedeals" :key="likedeal.dealIdx" :likedeal="likedeal" :class="''" class="card">
              <div class="image">
                <img :src="likedeal.imgUrl" alt="" />
              </div>
              <div>
                <h2 id="aptName">{{ likedeal.aptName }}</h2>
              </div>
              <div class="mainText">
                <!-- <h3 v-if="likedeal.superHost">전세</h3> -->
                <div style="display: flex">
                  <h5>{{ likedeal.dealAmount }}㎡, {{ likedeal.floor }}층</h5>
                  <!-- <h5 v-if="likedeal.beds">{{ likedeal.beds }} 제곱미터, 8층</h5> -->
                </div>
              </div>
              <div class="mainText" style="display: flex">
                <div style="display: flex">
                  <h4>{{ likedeal.buildYear }}년 준공</h4>
                </div>
                <!-- <div class="rating">
                  <i class="material-icons">★</i>
                  <span>{{ likedeal.rating }}</span> 
                </div>-->
              </div>
            </div>
          </div>
        </b-card>
      </b-tab>
    </b-tabs>

    <!-- <hr class="my-4"> -->
  </div>
</template>

<script>
import { mapState } from "vuex";
import http from "@/api/http.js";

const memberStore = "memberStore";

export default {
  name: "UserMyPage",
  components: {},
  data() {
    return {
      likedeals: [],
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods: {
    getLikeDeals() {
      const userIdx = this.userInfo.userIdx;
      http.get(`/like-deals/${userIdx}`).then(({ data }) => {
        console.log(data);
        this.likedeals = data;
      });
    },
  },
  created() {
    this.getLikeDeals();
  },
};
</script>

<style lang="scss" scoped>
#title {
  margin-top: 1rem;
}
h1 {
  font-style: normal;
  font-weight: bold;
  font-size: 24px;
  line-height: 29px;
  margin: 1rem 0rem;
  color: #333333;
}

#aptName {
  color: #17a2b8;
  font-weight: bold;
  font-size: 17px;
}
.section {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 1rem;
  position: relative;
  overflow-y: scroll;
  max-height: 710px;
}
.card {
  display: flex;
  flex-direction: column;
  position: relative;
  .image {
    position: relative;
    overflow: hidden;
    border-radius: 0.5rem;
    height: 250px;
    // margin-top: 0.5rem;
    img {
      width: 100%;
      height: 100%;
      transition: 0.5s all ease-out;
      &:hover {
        transform: scale(1.1);
      }
    }
  }
  .mainText {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    margin-left: 1rem;
    margin-right: 1rem;
    margin-top: 0.3rem;
    h2 {
      display: inline-block;
      font-weight: 600;
      font-size: 12px;
      line-height: 15px;
      color: #17a2b8;
      border: 1px solid black;
      padding: 0.35rem;
      border-radius: 0.75rem;
      white-space: nowrap;
    }
    div {
      h4 {
        font-weight: 800;
        font-size: 16px;
        line-height: 17px;
        color: #828282;
        white-space: nowrap;
      }
      h5 {
        font-weight: 800;
        font-size: 16px;
        line-height: 17px;
        color: #252525;
        white-space: nowrap;
      }
    }
  }
  .rating {
    display: flex;
    align-items: center;
    i {
      color: orange;
      font-size: 16px;
      line-height: 17px;
      padding-right: 5px;
    }
    span {
      font-style: normal;
      font-weight: 800;
      font-size: 16px;
      line-height: 17px;
      color: #828282;
    }
  }
  h2 {
    margin-top: 1rem;
    margin-left: 1rem;
    text-align: left;
    font-weight: 1000;
    font-size: 18px;
    line-height: 20px;
    color: #333333;
  }
  h4 {
    font-weight: 700;
  }
}
.none {
  display: none;
}
@media screen and (max-width: 1100px) {
  .card {
    .image {
      height: 200px;
    }
    .mainText {
      h3 {
        font-size: 13px;
        line-height: 13px;
      }
      div {
        h4,
        h5 {
          font-size: 15px;
          line-height: 15px;
        }
      }
      .rating {
        i {
          font-size: 15px;
          line-height: 15px;
          padding-right: 3px;
        }
        span {
          font-size: 15px;
          line-height: 15px;
        }
      }
    }
    h2 {
      font-size: 14px;
      line-height: 17px;
    }
  }
}
@media screen and (max-width: 770px) {
  .card {
    .image {
      height: 180px;
    }
    .mainText {
      h3 {
        font-size: 8px;
        line-height: 11px;
      }
      div {
        h4,
        h5 {
          font-size: 10px;
          line-height: 13px;
        }
      }
      .rating {
        i {
          font-size: 12px;
          line-height: 13px;
        }
        span {
          font-size: 10px;
          line-height: 13px;
        }
      }
    }
    h2 {
      font-size: 12px;
      line-height: 15px;
    }
  }
}
@media screen and (max-width: 430px) {
  .section {
    display: grid;
    grid-template-columns: 1fr;
    grid-gap: 1rem;
    position: relative;
  }
  .card {
    .image {
      height: 200px;
    }
  }
}
</style>
