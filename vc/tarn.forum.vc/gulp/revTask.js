const gulp = require("gulp");
const revCollector = require('gulp-rev-collector');
const rev = require('gulp-rev');
const runSequence = require('run-sequence');

gulp.task('revCss', function () {
    return gulp.src(['./app/css/**.css'])
        .pipe(rev())//添加hash后缀
        .pipe(gulp.dest('./app/css'))
        .pipe(rev.manifest({meger: true}))//生成文件映射
        .pipe(gulp.dest('./app/css'))//将映射文件导出到app/css
});

gulp.task('revJs', function () {
    return gulp.src(['./app/js/**.js'])
        .pipe(rev())//添加hash后缀
        .pipe(gulp.dest('./app/js'))
        .pipe(rev.manifest({meger: true}))//生成文件映射
        .pipe(gulp.dest('./app/js'))//将映射文件导出到app/js
});

gulp.task('revHtml', function() {
  return gulp.src(['./app/**/*.json', './dev/views/*.html'])
    .pipe(revCollector({replaceReved: true}))
    .pipe(gulp.dest('./app/views/'));
});

gulp.task("rev", (done) => {
    runSequence(
        ['revCss','revJs'],
        ['revHtml'],
    done);
});