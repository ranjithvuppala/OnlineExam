
//loginService.$inject = ['$http', '$cookieStore', '$rootScope'];

function loginService($http,$interpolate) {
    var userdata = $interpolate('/api/login/');

    return {

        verify: verify,

    };


    function verify(username, password) {
        var data = {
            username: username,
            password: password
        };

        return $http.post(userdata(), data);

    }

}