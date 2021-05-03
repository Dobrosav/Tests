const {Builder, By, Key, util}=require("selenium-webdriver");
var driver= new Builder().forBrowser("chrome").build()
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
function accept(){
    driver.findElement(By.className("MuiButtonBase-root")).click();
	driver.findElement(By.id("Test")).click();
}
async function openBrowser(){
    driver.get("https://classtranscribe-dev.ncsa.illinois.edu/")    
    sleep(10000)
    accept()
}


openBrowser()
//accept()