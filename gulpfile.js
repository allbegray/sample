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

    '/moment/min/moment-with-locales.min.js' : '/moment/'
  };

  for (var k in mappings) {
    gulp.src(BOWER_COMPONENTS_PATH + k).pipe(gulp.dest(DIST_PATH + mappings[k]));
    console.log('copy ' + (BOWER_COMPONENTS_PATH + k) + ' -> ' + (DIST_PATH + mappings[k]));
  }

});

gulp.task('default', ['bower_components_minify_copy']);