
function optionService($http, $interpolate) {
    var option1 = $interpolate('/api/Option/{{option_id}}');

    return {
        list: list,
        create: create,
        destroy: destroy,
        update: update
    };

    function list() {
        return $http.get(option1());
    }

    function create(option) {
        var data = {
            option:option
        };

        return $http.post(option1(), data);
    }

    function destroy(option_id) {
        return $http.delete(option1({ option_id: option_id }));
    }

    function update(id,option) {
        var data = {
            option:option
        };

        return $http.put(option1({ option_id: id }), data);
    }
}
