function appConfig($routeProvider) {
    $routeProvider
        .when('/login', { template: '<login-page></login-page>' })
        .when('/', { template: '<info></info>' })
        .when('/redirect', { template: '<questions></questions>'})
        .when('/info1', { template: '<info1></info1>' })
        .otherwise({
            redirectTo: '/'
        })
}

/*
function questionConfig($routeProvider) {
    $routeProvider
        .when('/info', { template: '<info1></info1>' })
        .when('/', { template: '<questions></questions>' })

        .otherwise({
            redirectTo: '/'
        })
}
    */