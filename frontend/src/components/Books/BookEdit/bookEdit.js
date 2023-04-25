import React from "react";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";

const BookEdit = (props) => {
    const navigate = useNavigate();

    const [formData, setFormData] = React.useState({
        name: "",
        author: 1,
        category: "NOVEL",
        availableCopies: 1,
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        const name = formData.name !== "" ? formData.name : props.currentBook.name;
        const author =
            formData.author !== 1 ? formData.author : props.currentBook.author.id;
        const category =
            formData.category !== "NOVEL"
                ? formData.category
                : props.currentBook.category;
        const availableCopies =
            formData.availableCopies !== "1"
                ? formData.availableCopies
                : props.currentBook.availableCopies;
        const id = props.currentBook.id;

        props.editCurrentBook(id, name, category, author, availableCopies);

        navigate("/books");
    };

    return (
        <div className="row mt-5 justify-content-center">
            <h2 className={"text-center"}>Edit book</h2>
            <div className="col-md-5">
                <form onSubmit={handleSubmit} autoComplete={"off"}>
                    <div className="form-group my-3">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.currentBook.name}
                               onChange={handleChange}/>
                    </div>

                    <div className="form-group my-3">
                        <label>Category</label>
                        <select name="category"
                                className="form-control"
                                onChange={handleChange}>
                            {props.categories.map((term) => {
                                if (props.currentBook.category !== undefined &&
                                    props.currentBook.category === term)
                                    return <option selected={props.currentBook.category} value={term}>{term}</option>
                                else return <option value={term}>{term}</option>
                            })}
                        </select>
                    </div>
                    <div className="form-group my-3">
                        <label>Author</label>
                        <select name="author"
                                className="form-control"
                                onChange={handleChange}>
                            {props.authors.map((term) => {
                                if (props.currentBook.author !== undefined &&
                                    props.currentBook.author.id === term.id)
                                    return <option selected={props.currentBook.author.id}
                                                   value={term.id}>{term.name + " " + term.surname}</option>
                                else return <option value={term.id}>{term.name + " " + term.surname}</option>
                            })}
                        </select>
                    </div>
                    <div className="form-group my-3">
                        <label htmlFor="availableCopies">Available Copies</label>
                        <input type="number"
                               className="form-control"
                               min={1}
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.currentBook.availableCopies}
                               onChange={handleChange}/>
                    </div>
                    <div className={"d-grid gap-2"}>
                        <button id="submit" type="submit" className="btn btn-primary my-3">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default BookEdit;