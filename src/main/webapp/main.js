let key = "90ad618fa3d2f888905f0b844cbb97df";
let base_url = "https://image.tmdb.org/t/p/w500";

Authentication = {
  "success": true,
  "expires_at": "2016-08-26 17:04:39 UTC",
  "request_token": "ff5c7eeb5a8870efe3cd7fc5c282cffd26800ecd"
}

function fetchMovie(page) {
  let url = `http://files.tmdb.org/p/exports/movie_ids_05_12_2022.json.gz`;
  fetch(url)
      .then(res => res.json())
      .then(function (res) {
          console.log(res);
      });
    }


    window.addEventListener('onLoad', fetchMovie());