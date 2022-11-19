<template>
<div>
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
        <div style="font-size: 1.2em;">
          {{userInfo.email}}
        </div>
        <div class="mt-2" style="font-size: 0.8em;">
          가입일: {{userInfo.joindate}}
        </div>
        <!-- <hr class="my-4"> -->
      </div>
      <b-row>
        <b-col >
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
  <hr class="my-4">
  <h3 id="title">찜한 매물</h3>
  <b-card no-body class="card-profile" alt="Image placeholder" img-top>
    <div class="section" style="margin: 10px">
      <div
        v-for="item in items"
        :key="item.id"
        :class="''"
        class="card"
      >
        <div class="image">
          <img :src="item.photo" alt="" />
        </div>
        <div>
          <h2>{{ item.title }}</h2>
        </div>
        <div class="mainText">
          <h3 v-if="item.superHost">전세</h3>
          <div style="display: flex">
            <h5 v-if="item.beds">{{ item.beds }} 제곱미터, 8층</h5>
          </div>
        </div>
        <div class="mainText" style="display: flex">
            <h4>{{ item.type }}</h4>
            <div class="rating">
              <i class="material-icons">★</i>
              <span>{{ item.rating }}</span>
            </div>
          </div>
        
      </div>
    </div>
  </b-card>
</div>
  
</template>

<script>
import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "UserMyPage",
  components: {},
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data(){
    return {
      items: [
        {
          "id": 1,
          "city": "Helsinki",
          "country": "Finland",
          "superHost": false,
          "title": "서울숲 아크로 포레스트",
          "rating": 4.4,
          "maxGuests": 3,
          "type": "28,000만원",
          "beds": 68.55,
          "photo": "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-1.2.1&auto=format&fit=crop&w=2255&q=80"
        },
        {
          "id": 2,
          "city": "Turku",
          "country": "Finland",
          "superHost": false,
          "title": "Nice apartment in center of Helsinki",
          "rating": 4.2,
          "maxGuests": 5,
          "type": "Entire apartment",
          "beds": 3,
          "photo": "https://images.unsplash.com/photo-1554995207-c18c203602cb?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80"
        },
        {
          "id": 3,
          "city": "Helsinki",
          "country": "Finland",
          "superHost": true,
          "title": "Arty interior in 1900 wooden house",
          "rating": 4.5,
          "maxGuests": 10,
          "type": "Entire house",
          "beds": 6,
          "photo": "https://images.unsplash.com/photo-1505691938895-1758d7feb511?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80"
        },
        {
          "id": 4,
          "city": "Helsinki",
          "country": "Finland",
          "superHost": false,
          "title": "Apartment next to market spuare",
          "rating": 4.48,
          "maxGuests": 3,
          "type": "Entire apartment",
          "beds": null,
          "photo": "https://images.unsplash.com/photo-1556020685-ae41abfc9365?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=934&q=80"
        },
        {
          "id": 5,
          "city": "Turku",
          "country": "Finland",
          "superHost": true,
          "title": "Villa Aurora guest-house",
          "rating": 4.75,
          "maxGuests": 9,
          "type": "Entire house",
          "beds": null,
          "photo": "https://images.unsplash.com/photo-1513694203232-719a280e022f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2249&q=80"
        },
        {
          "id": 6,
          "city": "Vaasa",
          "country": "Finland",
          "superHost": true,
          "title": "A cosy family house",
          "rating": 4.95,
          "maxGuests": 6,
          "type": "Entire house",
          "beds": null,
          "photo": "https://images.unsplash.com/photo-1524758631624-e2822e304c36?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80"
        },
        {
          "id": 7,
          "city": "Vaasa",
          "country": "Finland",
          "superHost": false,
          "title": "Lovely Studio near Railway Station",
          "rating": 4.68,
          "maxGuests": 2,
          "type": "Private room",
          "beds": null,
          "photo": "https://images.unsplash.com/photo-1505693314120-0d443867891c?ixlib=rb-1.2.1&auto=format&fit=crop&w=2591&q=80"
        },
        {
          "id": 8,
          "city": "Oulu",
          "country": "Finland",
          "superHost": false,
          "title": "Peaceful little home in city center",
          "rating": 4.12,
          "maxGuests": 6,
          "type": "Entire house",
          "beds": 3,
          "photo": "https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80"
        },
        {
          "id": 9,
          "city": "Oulu",
          "country": "Finland",
          "superHost": false,
          "title": "Beautiful new studio apartment nearby the center",
          "rating": 4.49,
          "maxGuests": 2,
          "type": "Entire apartment",
          "beds": 1,
          "photo": "https://images.unsplash.com/photo-1507089947368-19c1da9775ae?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2255&q=80"
        },
        {
          "id": 10,
          "city": "Oulu",
          "country": "Finland",
          "superHost": true,
          "title": "Cozy woodhouse flat with wooden sauna",
          "rating": 4.38,
          "maxGuests": 4,
          "type": "Entire house",
          "beds": null,
          "photo": "https://images.unsplash.com/photo-1522156373667-4c7234bbd804?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjF9&auto=format&fit=crop&w=930&q=80"
        },
        {
          "id": 11,
          "city": "Vaasa",
          "country": "Finland",
          "superHost": false,
          "title": "Brand new studio apartment near the harbour",
          "rating": 4.89,
          "maxGuests": 6,
          "type": "Entire apartment",
          "beds": 3,
          "photo": "https://images.unsplash.com/photo-1494203484021-3c454daf695d?ixlib=rb-1.2.1&auto=format&fit=crop&w=2250&q=80"
        },
        {
          "id": 12,
          "city": "Helsinki",
          "country": "Finland",
          "superHost": false,
          "title": "Beautiful and comfortable old wooden house",
          "rating": 4.63,
          "maxGuests": 10,
          "type": "Entire house",
          "beds": null,
          "photo": "https://images.unsplash.com/photo-1516455590571-18256e5bb9ff?ixlib=rb-1.2.1&auto=format&fit=crop&w=2250&q=80"
        },
        {
          "id": 13,
          "city": "Turku",
          "country": "Finland",
          "superHost": false,
          "title": "Turku Nordic Home near city center",
          "rating": 4.24,
          "maxGuests": 5,
          "type": "Entire apartment",
          "beds": 3,
          "photo": "https://images.unsplash.com/photo-1519643381401-22c77e60520e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjE3MzYxfQ&auto=format&fit=crop&w=2253&q=80"
        },
        {
          "id": 14,
          "city": "Turku",
          "country": "Finland",
          "superHost": true,
          "title": "Nice 2 room apartment close to everything",
          "rating": 4.34,
          "maxGuests": 6,
          "type": "Entire apartment",
          "beds": 3,
          "photo": "https://images.unsplash.com/photo-1523755231516-e43fd2e8dca5?ixlib=rb-1.2.1&auto=format&fit=crop&w=1275&q=80"
        }
      ]
    };
  },
  props:{

  }
};
</script>

<style lang="scss" scoped>
#title{
  margin-top: 1.0rem;
}
h1 {
  font-style: normal;
  font-weight: bold;
  font-size: 24px;
  line-height: 29px;
  margin: 1rem 0rem;
  color: #333333;
}
.section {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 1rem;
  position: relative;
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
    margin-top: 0.5rem;
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
    margin-left: 1.0rem;
    margin-right: 1.0rem;
    margin-top: 0.3rem;
    h3 {
      display: inline-block;
      font-weight: 600;
      font-size: 12px;
      line-height: 15px;
      color: #282828;
      border: 1px solid black;
      padding: 0.35rem;
      border-radius: 0.75rem;
      white-space: nowrap;
    }
    div {
      h4,
      h5 {
        font-weight: 800;
        font-size: 16px;
        line-height: 17px;
        color: #828282;
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
    margin-top: 1.0rem;
    margin-left: 1.0rem;
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