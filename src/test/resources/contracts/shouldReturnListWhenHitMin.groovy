import org.springframework.cloud.contract.spec.Contract

Contract.make {
  description "Should return list of values when min is fetched"
  request {
    method GET()
    urlPath("/min") {
      queryParameters {
        parameter 'quantifier': anyPositiveInt()
      }
    }
  }
  response {
    status 200
    body: [ anyPositiveInt(), anyPositiveInt() ]
  }
}