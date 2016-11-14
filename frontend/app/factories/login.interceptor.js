function loginInterceptor($location) {
    return {
        request: function(config) {
            return config;
        },

        requestError: authRedirect ,

        response: function(res) {
            return res;
        },

        responseError: authRedirect

    };

    function authRedirect(response){

        if(response.status === 401|| response.status === 403)
        {
            return response;
        }
        return response;

    }
}

