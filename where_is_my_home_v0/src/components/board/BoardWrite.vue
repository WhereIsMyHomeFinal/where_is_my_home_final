<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <h3>게시글 작성</h3>
      </b-col>
    </b-row>
    <board-input-item type="register" />
  </b-container>
</template>

<script>
import BoardInputItem from "@/components/board/item/BoardInputItem";

export default {
  name: "BoardWrite",
  components: {
    BoardInputItem,
  },
};
</script>

<style scoped>
h3 {
  text-align: start;
  margin-left: 0px;
}
</style>
