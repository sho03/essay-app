import classes from './TextArea.module.scss';

export function TextArea(props: { value: string, onChange: (e: React.ChangeEvent<HTMLTextAreaElement>) => void }) {

  const { value, onChange } = props;

  return (
    <textarea 
      value={value}
      onChange={onChange}
      placeholder={"Type or paste your text here..."}
      className={classes.textarea}
    />
  )
}

