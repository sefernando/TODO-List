console.log("controller page");

const createToDoItem = (id, toDoTitle, toDoDescription, toDoDate) => `
     <ul class="show-item">
        <li>delete</li>
        <button id="${id}">${id}</button>
        <li class="title item">${toDoTitle}</li>
        <li class="description item">${toDoDescription}</li>
        <li class="date item">${toDoDate}</li>
      </ul>
`;

//item controller class
class ItemController {
  constructor() {
    this._items = [];
  }

  //post data
  addItem(toDoTitle, toDoDescription, toDoDate) {
    console.log(toDoDate, toDoDescription, toDoTitle);
    let itemController = this;
    const formData = new FormData();
    formData.append("title", toDoTitle);
    formData.append("description", toDoDescription);
    formData.append("date", toDoDate);

    fetch("http://localhost:8080/item/add", {
      method: "POST",
      body: formData,
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("sucess post", data);
        alert("Item successfully added to the list");
      })
      .catch((e) => console.log(e));
  }

  //get data
  getItemDetails() {
    let itemController = this;
    itemController._items = [];

    fetch("http://localhost:8080/item/all")
      .then((response) => response.json())
      .then((data) => {
        console.log("items", data);
        itemController._items.push(...data);

        console.log("items", this._items);
        itemController.renderItemPage();
      })
      .catch((e) => console.log(e));
  }

  //render page
  renderItemPage() {
    let itemController = this;
    let itemHtmlList = [];
    this._items.forEach((item) => {
      const itemHTML = createToDoItem(
        item.id,
        item.title,
        item.description,
        item.date
      );
      itemHtmlList.push(itemHTML);
    });

    const iHTML = itemHtmlList.join("\n");
    console.log(iHTML);
    document.getElementById("items-container").innerHTML = iHTML;

    itemController.deleteItem();
  }

  //delete item
  deleteItem() {
    let itemController = this;
    let itemToDel;

    this._items.forEach((item) => {
      document.getElementById(item.id).addEventListener("click", () => {
        const url = "http://localhost:8080/item/" + item.id;
        console.log(url);

        fetch(url, {
          method: "DELETE",
        })
          .then((response) => {
            window.location.reload();
            return response.json();
          })
          .then((data) => {
            console.log("deleted successfully");
          })
          .catch((e) => console.log(e));
      });
    });
  }
}
