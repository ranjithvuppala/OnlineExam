
function choiceService($http, $interpolate) {
    var choice1 = $interpolate('/api/Choice/{{id}}');

    return {
        list: list,
        create: create,
        destroy: destroy,
        update: update
    };

    function list() {
        return $http.get(choice1());
    }

    function create(choice) {
        var data = {
            choice:choice
        };

        return $http.post(choice1(), data);
    }

    function destroy(id) {
        return $http.delete(choice1({ id: id }));
    }

    function update(id,choice) {
        var data = {
            choice:choice
        };

        return $http.put(choice1({ id: id }), data);
    }
}
