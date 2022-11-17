<template>
  <div class="pb-2 d-flex justify-content-evenly">
        <!-- <div class="btn-group">
          <button type="button" class="btn btn-primary">서울시</button>
        </div> -->
        <div class="col-lg-3 col-md-4 col-sm-4">
          <fieldset>
              <select v-model="selectSiName" @change="onSiMenuChange" class="array-select form-control form-select" aria-label="example">
                  <option value="default" selected>시 선택</option>
                  <option v-for="(item, index) in si" :key="index" :value="item.siCode">{{ item.siName }}</option>
              </select>
          </fieldset>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-4">
          <fieldset>
              <select v-model="selectGuName" @change="onGuMenuChange" class="array-select form-control form-select" aria-label="example">
                  <option value="default" selected>구 선택</option>
                  <option v-for="(item, index) in gu" :key="index" :value="item.guCode">{{ item.guName }}</option>
              </select>
          </fieldset>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-4">
          <fieldset>
              <select v-model="selectDongName" @change="onDongMenuChange" class="array-select form-control form-select" aria-label="example">
                  <option value="default" selected>동 선택</option>
                  <option v-for="(item, index) in dong" :key="index" :value="item.dongName">{{ item.dongName }}</option>
              </select>
          </fieldset>
        </div>
      </div>
</template>
<script>
export default {
  
}
</script>
<style scoped>
  
</style>