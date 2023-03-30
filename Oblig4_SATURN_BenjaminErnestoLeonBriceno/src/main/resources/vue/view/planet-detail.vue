<template id="planet-detail">
  <div class="content-wrapper">
    <div v-if="planet" class="detail-planet-container">
        {{console.log(this.planet)}}
        <h1>{{planet.name}}</h1>
        <img v-if="planet.pictureUrl" class="cover-image" v-bind:src="planet.pictureUrl">
        <img v-else class="cover-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">

        <p>The mass of {{planet.name}} is {{planet.massInKg}} kg, it has a radius of {{planet.radiusInKm}} km,
            the eccentricity or the deviation of orbit is from a circularity of {{planet.eccentricity}}.</p>
        <p>It spins around the star {{planet.centralCelestialBody.name}} with an orbiting period of {{planet.orbitalPeriod}} days.</p>
        <p>{{planet.name}} has {{Grammar(moons)}} revolving around itself.</p>
    </div>
      <ul class="moon-overview-list">
          <li v-for="moon in moons">
              <div class="single-moon-container" >
                 <h1>{{moon.name}}</h1>
                    <img v-if="moon.pictureUrl" class="list-image" v-bind:src="moon.pictureUrl">
                    <img v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
              </div>
          </li>
      </ul>

  </div>
</template>
<script>
    Vue.component("planet-detail", {
        template: "#planet-detail",
        data: () => ({
            planet: null,
            planetSystemName: "",
            moons: [],
        }),
        created() {
            const planetSystemId = this.$javalin.pathParams["planet-system-id"];
            this.planetSystemName = planetSystemId;
            console.log("Planet system id: " + planetSystemId);
            const planetId = this.$javalin.pathParams["planet-id"];
            fetch(`/api/planet-system/${planetSystemId}/planets/${planetId}`)
                .then(res => res.json())
                .then(res => this.planet = res)
                .catch(() => alert("Error while fetching planet"));
            fetch(`/api/planet-system/${planetSystemId}/planets/${planetId}/moons`)
                .then(res => res.json())
                .then(res => this.moons = res)
                .catch(() => alert("Error while fetching moons"))
        }
    });
    function Grammar(moonsList) {
      if (moonsList.length === 1)
        return moonsList.length + " moon";

      return moonsList.length + " moons";
    }
</script>
<style>
    ul{
       color:white;
    }
    div.detail-planet-container > p {
        max-width: 30em;
    }
    div.detail-planet-container{
        padding-top: 10px;
        overflow: hidden;
        width: 500px;
        background-color: #000000;
        color: white;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.planet-cover-image {
        height: 320px;
        width: 320px;
        padding-bottom: 20px;
    }
    .moon-overview-list{
      color:black;
      display: flex;
      flex-wrap: wrap;
      justify-content: space-around;

    }
    div.single-moon-container{
      overflow: hidden;
      color: white;
      background-color: rgba(0, 0, 0, 0.98);
      margin: 0 auto;
      opacity: 0.96;
      text-align: center;
    }

    #sortList{
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
      margin-top: 30px;
      margin-bottom: 30px;
    }

    #sortList li{
      padding: 10px;
      margin: 10px;
      border: 1px solid white;
      color: white;
      border-radius: 15px;
    }

    #sortList li a{
      color: white;
      text-decoration: none;
      font-weight: bold;
    }

    #sortList li:hover{
      border: 2px solid white;
    }
    img.list-image {
      width: 140px;
      padding-bottom: 20px;
      transition: transform .2s;
    }

    .list-image:hover{
      transform: scale(1.1);
    }

    .button {
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }

    button a{
        color: white;
        text-decoration: none;
        font-weight: bold;
    }

    .button:hover{
        border: 2px solid white;
    }

</style>