function appConfig($routeProvider) {
    $routeProvider
        .when('/login', { template: '<login-page></login-page>' })
        .when('/', { template: '<info></info>' })

        .otherwise({
            redirectTo: '/'
        })
}