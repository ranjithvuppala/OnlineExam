
function optionService($http, $interpolate) {
    var option = $interpolate('/api/Option/{{option_id}}');

    return {
        list: list,
        create: create,
        destroy: destroy,
        update: update
    };

    function list() {
        return $http.get(option());
    }

    function create(option) {
        var data = {
            option:option
        };

        return $http.post(option(), data);
    }

    function destroy(option_id) {
        return $http.delete(option({ option_id: option_id }));
    }

    function update(id,option) {
        var data = {
            option:option
        };

        return $http.put(option({ option_id: id }), data);
    }
}
