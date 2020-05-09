const gulp = require("gulp");
const sass = require("gulp-sass");
const cleanCSS = require("gulp-clean-css");
const browserSync = require("browser-sync").create();
const rename = require("gulp-rename");
const autoprefixer = require("gulp-autoprefixer");

const isDev = process.env.npm_lifecycle_script === "gulp dev";
const baseUrl = "./";

gulp.task("scss:login", () => {
    return gulp.src([baseUrl+"dev/scss/login.scss"])
        .pipe(sass().on("error", sass.logError))
        .pipe(autoprefixer({
            browsers: ["last 20 versions"],
            cascade: false
        }))
        .pipe(cleanCSS({
            compatibility: "ie8",
            format: isDev ? "beautify" : false
        }))
        .pipe(rename({suffix: ".min"}))
        .pipe(gulp.dest(baseUrl+"app/css/"))
        .pipe(browserSync.stream());
});

gulp.task("scss:pages", () => {
    return gulp.src([baseUrl+"dev/scss/style.scss"])
        .pipe(sass().on("error", sass.logError))
        .pipe(autoprefixer({
            browsers: ["last 20 versions"],
            cascade: false
        }))
        .pipe(cleanCSS({
            compatibility: "ie8",
            format: isDev ? "beautify" : false
        }))
        .pipe(rename({suffix: ".min"}))
        .pipe(gulp.dest(baseUrl+"app/css/"))
        .pipe(browserSync.stream());
});



