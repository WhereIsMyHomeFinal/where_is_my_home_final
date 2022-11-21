// import { likedealList } from "@/api/likedeal";

// const likedealStore = {
//   namespaced: true,
//   state: {
//     likedeals: [],
//   },
//   getters: {
//     likedeals(state) {
//       return state.depts;
//     },
//   },
//   mutations: {
//     [SET_LIKEDEAL_LIST] (state, likedeals) {
//       state.likedeals = likedeals;
//     },
//   },
//   actions: {
//     [getLikeDeals({ commit }, user_idx) {
//       await likedealList(
//         user_idx,
//         ({ data }) => {
//           commit("SET_LIKEDEAL_LIST", data);
//         },
//         (error) => {
//           console.log(error);
//         }
//       );
//     },
//   },
// };

// export default likedealStore;
