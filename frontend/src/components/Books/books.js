import React from "react";
import BookTerm from "./BookTerm/bookTerm";
import { Link } from "react-router-dom";
import ReactPaginate from "react-paginate";

class Books extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            page: 0,
            size: 5,
        };
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.books.length / this.state.size);
        const books = this.getBooksPage(offset, nextPageOffset);

        return (
            <div className="container">
                <div className="row d-flex justify-content-center">{books}</div>
                <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12 d-grid gap-2">
                            <Link className={"btn btn-dark"} to={"/books/add"}>Add new book</Link>
                        </div>
                    </div>
                </div>
                <ReactPaginate
                    previousLabel={"<"}
                    nextLabel={">"}
                    breakLabel={<a href="/#">...</a>}
                    containerClassName={"pagination flex justify-content-center"}
                    breakClassName={"page-item"}
                    breakLinkClassName={"page-link"}
                    activeClassName={"page-item active"}
                    previousClassName={"page-item"}
                    previousLinkClassName={"page-link"}
                    nextClassName={"page-item"}
                    nextLinkClassName={"page-link"}
                    pageClassName={"page-item"}
                    pageLinkClassName={"page-link"}
                    pageCount={pageCount}
                    marginPagesDisplayed={2}
                    pageRangeDisplayed={5}
                    onPageChange={this.handlePageClick}
                />
            </div>
        );
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected,
        });
    };

    getBooksPage = (offset, nextPageOffset) => {
        return this.props.books
            .map((item) => {
                return (
                    <div key={item.id} className="col-sm-12 col-md-6 col-lg-4">
                        <BookTerm
                            currentItem={item}
                            getCurrentBook={this.props.getCurrentBook}
                            onDeleteCurrentBook={this.props.onDeleteCurrentBook}
                            currentBook={this.props.currentBook}
                            changeCopiesValue={this.props.changeCopiesValue}
                        />
                    </div>
                );
            })
            .filter((book, index) => {
                return index >= offset && index < nextPageOffset;
            });
    };
}
export default Books;
