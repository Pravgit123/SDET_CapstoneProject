
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time
driver = webdriver.Chrome()  

driver.maximize_window()  
#navigate to the url  
driver.get("https://www.w3schools.com/")  
time.sleep(2)
element=driver.find_element(By.XPATH, "//i[@class=\"fa fa-logo ws-hover-text-green\"]")
if element.is_displayed():
    print("Logo is Visible")