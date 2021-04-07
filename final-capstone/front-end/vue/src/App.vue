<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Back To Search</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'addBrewery' }">Add New Brewery</router-link>
    </div>
    <router-view />
  </div>
</template>
