
//loginService.$inject = ['$http', '$cookieStore', '$rootScope'];

function loginService($http,$interpolate) {
    var userdata = $interpolate('/api/login/');

    return {

        verify: verify,
        ClearHeaders : ClearHeaders

    };


    function verify(username, password) {
        var data = {
            username: username,
            password: password
        };

        return $http.post(userdata(), data);

    }

    function ClearHeaders(){

        $http.defaults.headers.common.Authorization = 'Basic';
    }



}

