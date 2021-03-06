'use strict';

angular.module('demo')
    .factory('ProductService', function ($http) {
        return {
            loadAllProducts: function () {
                return $http.get('/product/search/all').then(function(response) {
                   return response.data;
                });
            },
            loadProductsBySubcategoryId: function (subcategoryId) {
                return $http.get('/product/search/' + subcategoryId).then(function(response) {
                   return response.data;
                });
            }
        }
    });

