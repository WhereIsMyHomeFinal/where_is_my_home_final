<template>
  <b-container class="bv-example-row mt-3">
    <h3>게시글 수정</h3>
    <board-input-item type="modify" />
  </b-container>
</template>

<script>
import BoardInputItem from "@/components/board/item/BoardInputItem";

export default {
  name: "BoardModify",
  components: {
    BoardInputItem,
  },
};
</script>

<style scoped>
h3 {
  text-align: center;
  margin-left: 0px;
}
</style>
