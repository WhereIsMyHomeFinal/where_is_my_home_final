<template>
  <div>
    <b-navbar toggleable="lg" type="light" variant="light">
      <b-navbar-brand href="#">
        <router-link :to="{ name: 'main' }" class="link title-link">
          <div class="item col-md-2 text-info"><h1>구해줘홈즈</h1></div>
        </router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="#">
            <!-- <router-link :to="{ name: 'main' }" class="link">
              <b-icon icon="house-door" animation="fade" font-scale="2"></b-icon>
              메인
            </router-link>
            <router-link :to="{ name: 'insta' }" class="m-2 link">
              <b-icon icon="instagram" animation="fade" font-scale="2"></b-icon>
              인스타그램
            </router-link> -->
            <router-link :to="{ name: 'house' }" class="m-2 link">
              <!-- <b-icon icon="house-fill" animation="fade" font-scale="2"></b-icon> -->
              매물 검색
            </router-link>
            <router-link :to="{ name: 'board' }" class="m-2 link">
              <!-- <b-icon icon="journal" animation="fade" font-scale="2"></b-icon> -->
              게시판
            </router-link>
            <!-- <router-link :to="{ name: 'todo' }" class="link">
              <b-icon icon="calendar-check" animation="fade" font-scale="2"></b-icon>
              TodoList
            </router-link> -->
          </b-nav-item>
        </b-navbar-nav>

        <!-- after login -->
        <b-navbar-nav class="ml-auto" v-if="userInfo">
          <b-nav-item class="align-self-center">
            <b-avatar variant="primary" :src="require('@/assets/profile_01.png')"></b-avatar>
            {{ userInfo.username }}({{ userInfo.userid }})님 환영합니다.
          </b-nav-item>
          <b-nav-item class="align-self-center">
            <router-link :to="{ name: 'mypage' }" class="link align-self-center">MY PAGE</router-link>
          </b-nav-item>
          <b-nav-item class="link align-self-center logout-link" @click.prevent="onClickLogout">LOGOUT</b-nav-item>
        </b-navbar-nav>
        <!-- before login -->
        <b-navbar-nav class="ml-auto" v-else>
          <b-nav-item right class="align-self-center">
            <router-link :to="{ name: 'login' }" class="link align-self-center login-link">
              <b-icon icon="key"></b-icon> LOGIN
            </router-link>
          </b-nav-item>
          <!-- <b-nav-item-dropdown right>
            <template #button-content>
              <b-icon icon="people" font-scale="2"></b-icon>
            </template>
            <b-dropdown-item href="#">
              <router-link :to="{ name: 'join' }" class="link">
                <b-icon icon="person-circle"></b-icon> 회원가입
              </router-link>
            </b-dropdown-item>
            <b-dropdown-item href="#">
              <router-link :to="{ name: 'login' }" class="link"> <b-icon icon="key"></b-icon> LOGIN </router-link>
            </b-dropdown-item>
          </b-nav-item-dropdown> -->
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import { mapState, mapGetters, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "TheHeaderNavbar",
  data() {
    return {};
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userLogout"]),
    // ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    onClickLogout() {
      // this.SET_IS_LOGIN(false);
      // this.SET_USER_INFO(null);
      // sessionStorage.removeItem("access-token");
      // if (this.$route.path != "/") this.$router.push({ name: "main" });
      console.log(this.userInfo.userid);
      //vuex actions에서 userLogout 실행(Backend에 저장 된 리프레시 토큰 없애기
      //+ satate에 isLogin, userInfo 정보 변경)
      // this.$store.dispatch("userLogout", this.userInfo.userid);
      this.userLogout(this.userInfo.userid);
      sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
      sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
      if (this.$route.path != "/") this.$router.push({ name: "main" });
    },
  },
};
</script>

<style>
#logo {
  width: 120px;
}

.link {
  text-decoration: none;
  /* color: #17a2b8; */
  color: black;
  height: 40px;
  margin: 0px;
  display: inline-block;
  height: 24px;
}

.title-link {
  height: 40px;
}

.login-link {
  padding: 0px;
}

.logout-link {
  margin-top: -16px;
}

h1 {
  height: 40px;
}

.link:hover {
  text-decoration: none;
  color: #17a2b8;
}

.link.router-link-active,
.link.router-link-exact-active {
  margin: 0px;
}

/* li:hover a, */
li.router-link-active a,
li.router-link-exact-active a {
  margin: 0px;
}

/* li a {
  color: #17a2b8;
} */
</style>
