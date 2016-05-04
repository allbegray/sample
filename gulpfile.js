var BOWER_COMPONENTS_PATH = 'bower_components';
var DIST_PATH = 'webapp/resources/lib';

var gulp = require('gulp'),
    uglify = require('gulp-uglify'),
    del = require('del');

gulp.task('clean', function() {
  del([DIST_PATH]);
});

gulp.task('bower_components_minify_copy', ['clean'], function () {

  var mappings = {

    '/bootstrap/dist/css/*.min.*' : '/bootstrap/css/',
    '/bootstrap/dist/fonts/*.*' : '/bootstrap/fonts/',
    '/bootstrap/dist/js/*.min.js' : '/bootstrap/js/',

    '/font-awesome/fonts/*.*' : '/font-awesome/fonts/',
    '/font-awesome/css/font-awesome.min.css' : '/font-awesome/css/',

    '/jquery/dist/jquery.min.js' : '/jquery/',

    '/jquery-number/jquery.number.min.js' : '/jquery/',

    '/underscore/underscore-min.js' : '/underscore/',

    '/moment/min/moment-with-locales.min.js' : '/moment/',

    '/bootstrap-table/dist/*.min.*' : '/bootstrap-table/',
    '/bootstrap-table/dist/extensions/*/*.min.js' : '/bootstrap-table/extensions',
    '/bootstrap-table/dist/extensions/*/*.css' : '/bootstrap-table/extensions',

    '/parsleyjs/dist/*.min.js' : '/parsleyjs/',
    '/parsleyjs/dist/i18n/ko.js' : '/parsleyjs/i18n/',

    '/blockui/jquery.blockUI.js' : '/jquery/',

    '/bootstrap-datepicker/dist/css/*.min.css' : '/bootstrap-datepicker/css',
    '/bootstrap-datepicker/dist/js/*.min.js' : '/bootstrap-datepicker/js',
    '/bootstrap-datepicker/dist/locales/*.ko.min.js' : '/bootstrap-datepicker/locales',

  };

  for (var k in mappings) {
    gulp.src(BOWER_COMPONENTS_PATH + k).pipe(gulp.dest(DIST_PATH + mappings[k]));
    console.log('copy ' + (BOWER_COMPONENTS_PATH + k) + ' -> ' + (DIST_PATH + mappings[k]));
  }

});

gulp.task('default', ['bower_components_minify_copy']);