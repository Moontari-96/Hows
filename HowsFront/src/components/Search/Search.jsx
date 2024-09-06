import React, { useState } from 'react'
import styles from './Search.module.css'
import axios from 'axios'

export const Search = ({ placeholder = 'Search...', onSearch, size }) => {
    const [searchValue, setSearchValue] = useState('')

    const handleSearch = () => {
        if (onSearch) {
            onSearch(searchValue) // 검색 버튼 클릭 시, onSearch 함수를 호출하고 query 값을 전달
        }
    }

    return (
        <div className={`${styles.searchBox} ${styles[size]}`}>
            <input
                type="text"
                value={searchValue}
                placeholder={placeholder} // 사용자 정의 placeholder
                onChange={e => setSearchValue(e.target.value)}
            />
            <button
                className={styles.searchBtn}
                type="button"
                onClick={handleSearch} // 버튼 클릭 시 검색 동작
            >
                <i className="bx bx-search" />
            </button>
        </div>
    )
}
