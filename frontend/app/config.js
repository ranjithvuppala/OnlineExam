function appConfig($routeProvider) {
    $routeProvider
        .when('/login', { template: '<login-page></login-page>' })
        .when('/', { template: '<info></info>' })

        .otherwise({
            redirectTo: '/'
        })
}


function questionConfig($routeProvider) {
    $routeProvider
        .when('/info', { template: '<info1></info1>' })
        .when('/', { template: '<questions></questions>' })

        .otherwise({
            redirectTo: '/'
        })
}