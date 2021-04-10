<template>
    <div>
        <img src="../assets/hops.png" style="width: 40px">
        <span> Brewery Finder </span>

        <button type="button">LOGIN</button>
    </div>
</template>

<script>

export default {
    name: 'theHeader'
}
</script>

<style scoped>
    @import url('https://fonts.googleapis.com/css2?family=Chango&display=swap');

span {
    font-family: chango;
    font-size: 40px;
}

button {
    background-color:green;
    padding: 10px;
    border: none;
    border-radius: 5px;
    color: white;
}

</style>
