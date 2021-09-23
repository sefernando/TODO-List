console.log("in the item form");
const itemController = new ItemController();

document.getElementById("item-form").addEventListener("submit", (e) => {
  e.preventDefault();

  const toDoTitle = document.getElementById("title").value;
  const toDoDescription = document.getElementById("description").value;
  const toDoDate = document.getElementById("target-date").value;

  itemController.addItem(toDoTitle, toDoDescription, toDoDate);
});
