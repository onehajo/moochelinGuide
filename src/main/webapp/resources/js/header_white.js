

const header = document.querySelector(".scroll");
const headerHeight = header.getBoundingClientRect().height;


window.addEventListener("scroll", () => {
      if (window.scrollY > 350) {
         header.classList.remove("scroll");
         
      } else {
         
         header.classList.add("scroll");

      }
   });
   