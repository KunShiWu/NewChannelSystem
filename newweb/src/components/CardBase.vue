<template>
  <div class="card-base" >
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: 'CardBase'
}
</script>

<style scoped>
.card-base {
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
  padding: 20px;
  margin: 16px;
}
</style>