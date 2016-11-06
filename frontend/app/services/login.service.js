function loginService($http,$interpolate,$cookies) {
    var userdata = $interpolate('/api/login/');

    return {

        verify: verify,
        ClearHeaders: ClearHeaders,
        SetHeaders: SetHeaders

    };


    function verify(username, password) {
        var data = {
            username: username,
            password: password
        };

        return $http.post(userdata(), data);

    }

    function ClearHeaders() {
        $http.defaults.headers.common.Authorization = 'Basic';
        $cookies.remove('authdata');
    }


    function SetHeaders(username, password) {
        var authdata = Base64.encode(username + ':' + password);
        $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
        $cookies.put('authdata',authdata);
     }


}

var Base64 = {

    keyStr: 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',

    encode: function (input) {
        var output = "";
        var chr1, chr2, chr3 = "";
        var enc1, enc2, enc3, enc4 = "";
        var i = 0;

        do {
            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);

            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;

            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }

            output = output +
                this.keyStr.charAt(enc1) +
                this.keyStr.charAt(enc2) +
                this.keyStr.charAt(enc3) +
                this.keyStr.charAt(enc4);
            chr1 = chr2 = chr3 = "";
            enc1 = enc2 = enc3 = enc4 = "";
        } while (i < input.length);

        return output;
    }


};
