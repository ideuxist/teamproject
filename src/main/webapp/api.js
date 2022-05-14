// api 정보를 호출하는 js 입니다.

// fetch 사용법
// fetch(url, options)
// -> promise 객체 반환
// 성공 시 response 객체를 resolve, 실패 시 error 객체를 reject
fetch(url, options)
  .then((response) => console.log("response:", response))
  .catch((error) => console.log("error:", error));
  // option 객체 : HTTP 방식(method), HTTP 요청 헤더(headers), HTTP 요청 전문(body)
  // response 객체 : HTTP 응답 상태(status), HTTP 응답 헤더(headers), HTTP 응답 전문(body)
  // fetch() 함수는 엄밀히 window 객체에 소속되어 window.fetch()로 사용되기도 한다.


  // GET 호출
  // 단순히 원격 API에 있는 데이터를 가져올 때 쓰이는 GET 방식 HTTP 통신
  // default 값이기에 옵션 인자 필요  x
  fetch("https://jsonplaceholder.typicode.com/posts/1")
        .then((response) =>
            console.log(response)
        );

// 대부분 REST API는 JSON 형태 데이터를 응답 -> response 객체는 json() 메서드 제공
fetch("https://jsonplaceholder.typicode.com/posts/1")
  .then((response) => response.json()) // json 응답 전문을 JS 객체로 변환하여 얻음.
  .then((data) => console.log(data)); // 그 변환 값을 data로 명명했을 때 함수

// 특정 API에 저장된 데이터를 보여주는 웹페이지, 애플리케이션에서는 GET 방식의 HTTP 통신으로 충분함.




// POST 호출
// 원격 API에서 관리하고 있는 데이터를 생성 시, 요청 전문을 포함할 수 있는 POST 방식의 HTTP 통신 필요
// + headers 옵션을 통해 JSON 포멧을 사용한다고 알려줘야 함.
// + 요청 전문을 JSON 포멧으로 직렬화하여 가장 중요한 body 옵션에 설정
    fetch("", {
        method : "POST",
        headers : {
            "content_Type" : "application/json",
        },
        body : JSON.stringify({
            title : "Test",
            body : "I am testing!",
            userId : 1,
        }),
    })
        .then((response) => console.log(response));

        // 직렬화?
        // 